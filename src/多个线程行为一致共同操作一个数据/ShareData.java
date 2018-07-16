package 多个线程行为一致共同操作一个数据;

/**
 * @author Tainy
 * @date 2018/5/31 14:07
 */
public class ShareData {
    private volatile int num = 0;
    public synchronized void inc(){
        num++;
        System.out.println("当前线程为：" + Thread.currentThread().getName() + " inc method num = " + num + "!");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[num=" + num + "]";
    }
}
