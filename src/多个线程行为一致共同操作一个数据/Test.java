package 多个线程行为一致共同操作一个数据;

/**
 * @author Tainy
 * @date 2018/5/31 15:40
 */
public class Test {
    public static void main(String[] args) {
        final ShareData shareData = new ShareData();
        for(int i = 0; i < 5000; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    shareData.inc();
                }
            }).start();
        }
        System.out.println(shareData);
    }
}
