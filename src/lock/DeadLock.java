package lock;

/**
 * 死锁
 */
public class DeadLock{
    // 声明称静态类型，为该类所有对象共有资源
    private static Object locka = new Object();
    private static Object lockb = new Object();

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    /**
     * 产生死锁
     *
     * 线程thread1先获取locka对象锁，然后在同步代码块里面去获取lockb对象锁
     * 线程thread2先获取lockb对象锁，然后在同步代码块里面去获取locka对象锁
     * 通过Thread.sleep(500)保证thread1先于thread2获取locka对象锁
     * 通过Thread.sleep(500)保证thread2先于thread1获取lockb对象锁
     * 当thread1去获取lockb对象锁时，由于lockb对象锁已经被thread2占用，所以thread1处于阻塞等待thread2释放lockb对象锁
     * 当thread2去获取locka对象锁时，由于locka对象锁已经被thread1占用，所以thread2处于阻塞等待thread1释放locka对象锁
     * 循环等待，造成死锁
     */
    private void deadLock(){
        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locka){
                    try {
                        System.out.println(Thread.currentThread().getName() + " get locka's lock");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " 执行任务花费了 500ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 此时需要获取资源 lockb 锁！Waiting~~~");
                    synchronized (lockb){
                        System.out.println(Thread.currentThread().getName() + " get lockb's lock(由于发生死锁，永远无法打印出来)");
                    }
                }
            }
        });
        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockb){
                    try {
                        System.out.println(Thread.currentThread().getName() + " get lockb's lock");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " 执行任务花费了 500ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 此时需要获取资源 locka 锁！Waiting~~~");
                    synchronized (locka){
                        System.out.println(Thread.currentThread().getName() + " get locka's lock(由于发生死锁，永远无法打印出来)");
                    }
                }
            }
        });
        // 启动线程
        thread1.start();
        thread2.start();
    }

}
