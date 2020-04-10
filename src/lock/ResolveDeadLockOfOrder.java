package lock;

/**
 * 通过指定锁的获取顺序解决死锁
 */
public class ResolveDeadLockOfOrder {
    // 声明称静态类型，为该类所有对象共有资源
    private static Object locka = new Object();
    private static Object lockb = new Object();

    public static void main(String[] args) {
        new ResolveDeadLockOfOrder().deadLock();
    }

    /**
     * 通过指定锁的获取顺序解决死锁
     * 比如指定：先获取locka资源锁，才获取lockb资源锁
     * 由于线程2先获取的lockb资源锁，后获取的locka锁，所以可以改成先获取locka资源锁，在获取lockb资源锁
     */
    private void deadLock(){
        // 线程1
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locka){
                    System.out.println(Thread.currentThread().getName() + " 先获取locka资源锁");
                    try {
                        System.out.println(Thread.currentThread().getName() + " get locka's lock");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + " 执行任务花费了 500ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockb){
                        System.out.println(Thread.currentThread().getName() + " 获取locka资源锁后，再获取lockb资源锁");
                        System.out.println(Thread.currentThread().getName() + " get lockb's lock");
                    }
                }
            }
        });
        // 线程2
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 获取lockb资源锁时阻塞！Waiting~~~");
                synchronized (locka){
                    System.out.println(Thread.currentThread().getName() + " 先获取locka资源锁");
                    System.out.println(Thread.currentThread().getName() + " get locka's lock");
                    synchronized (lockb){
                        System.out.println(Thread.currentThread().getName() + " 获取locka资源锁后，再获取lockb资源锁");
                        System.out.println(Thread.currentThread().getName() + " get lockb's lock");

                        System.out.println(Thread.currentThread().getName() + " 执行业务");
                    }
                }

            }
        });
        // 启动线程
        thread1.start();
        thread2.start();
    }

}
