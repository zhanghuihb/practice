package 多个线程行为不一致共同操作一个数据;

/**
 * @author Tainy
 * @date 2018/5/31 14:18
 */
public class ShareData {

    private int num = 100;

    public synchronized void inc(){
        num++;
        System.out.println("当前线程为：" + Thread.currentThread().getName() + " inc method num = " + num + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dec(){
        num--;
        System.out.println("当前线程为：" + Thread.currentThread().getName() + " dec method num = " + num + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
