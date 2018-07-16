package 多个线程行为一致共同操作一个数据;

/**
 * @author Tainy
 * @date 2018/5/31 14:10
 */
public class RunnableCusToIns implements Runnable{

    private ShareData shareData;

    public RunnableCusToIns(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            shareData.inc();
        }
    }

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for(int i = 0; i < 4; i++){
            new Thread(new RunnableCusToIns(shareData), "Thread_" + i).start();
        }
    }
}
