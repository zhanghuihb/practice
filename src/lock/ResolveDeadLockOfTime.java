package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过指加锁时限解决死锁
 */
public class ResolveDeadLockOfTime {
    public static void main(String[] args) {
        new ResolveDeadLockOfTime().deadLock();
    }

    /**
     * 产生死锁
     *
     */
    private void deadLock(){
        final ReentrantLockBean reentrantLockBean = new ReentrantLockBean();
        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    reentrantLockBean.productDeadLock();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 设置500，为了让thread1大概率先获得lock对象锁
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    reentrantLockBean.productDeadLock();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        // 启动线程
        thread1.start();
        thread2.start();
    }

    public static class ReentrantLockBean{
        private Lock lock = new ReentrantLock();
        public void productDeadLock() throws Throwable {
            System.out.println(Thread.currentThread().getName() + " 进入方法");
            System.out.println(Thread.currentThread().getName() + " 获取对象锁等待中。。。");
            // tryLock()方法无论是否获取到对象锁，都会返回，并且是可以中断的
            // 3秒后，如果还未获取到对象锁，返回false
            final boolean tryLock = lock.tryLock(3, TimeUnit.SECONDS);
            if(tryLock){
                try{
                    System.out.println(Thread.currentThread().getName() + " 获取对象锁成功");
                    System.out.println(Thread.currentThread().getName() + " 执行代码发生异常");
                    throw new Throwable("执行代码发生异常");
                } catch (Exception e){
                    System.out.println(Thread.currentThread().getName() + " 发生异常");
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " 发生异常释放对象锁成功");
                } finally {
                    // 此处如果没有释放，会造成死锁
//                lock.unlock();
//                System.out.println(Thread.currentThread().getName() + " finally里释放对象锁成功");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " 获取对象锁超时，稍后会重试获取");
            }

        }
    }
}
