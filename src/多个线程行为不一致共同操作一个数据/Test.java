package 多个线程行为不一致共同操作一个数据;

/**
 * @author Tainy
 * @date 2018/5/31 14:35
 */
public class Test {

    public static void main(String[] args) {
        final ShareData shareData = new ShareData();
        for(int i = 0; i<4; i++){
            if(i%2 == 0){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i<5;i++){
                            shareData.inc();
                        }
                    }
                }, "Thread_" + i).start();
            }else{
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i<5;i++){
                            shareData.dec();
                        }
                    }
                }, "Thread_" + i).start();
            }
        }
    }
}
