package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁
 */
public class DeadReentrantLock {
    public static void main(String[] args) {
        new DeadReentrantLock().deadLock();
    }

    /**
     * 产生死锁
     *
     * 线程thread1先获取lock对象锁，然后代码执行完后未释放锁或者执行代码抛出异常导致锁没有正确释放
     * 线程thread2获取lock对象锁时，由于thread1未正确释放lock对象锁，thread2一直处于阻塞等待状态，造成死锁
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
            // lock（）方法 为什么必须在try代码块之外？
//            在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在finally中无法解锁。
//            说明一：如果在lock方法与try代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
//            说明二：如果lock方法在try代码块之内，可能由于其它方法抛出异常，导致在finally代码块中，unlock对未加锁的对象解锁，它会调用AQS的tryRelease方法（取决于具体实现类），抛出IllegalMonitorStateException异常。
//            说明三：在Lock对象的lock方法实现中可能抛出unchecked异常，产生的后果与说明二相同。
            System.out.println(Thread.currentThread().getName() + " 获取对象锁等待中。。。");
            lock.lock();
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
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " finally里释放对象锁成功");
            }
        }
    }
}