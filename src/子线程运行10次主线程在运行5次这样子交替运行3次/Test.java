package 子线程运行10次主线程在运行5次这样子交替运行3次;

/**
 * @author Tainy
 * @date 2018/5/31 13:32
 */
public class Test {
    private boolean subFlag = true;

    public synchronized void mainMethod(){
        while (subFlag){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        for(int i = 0; i < 5; i++){
            System.out.println("当前线程：" + Thread.currentThread().getName() + "为主线程，第：" + (i + 1) + "次运行!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = true;
        notify();
    }

    public synchronized void subMethod(){
        if(!subFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 10; i++){
            System.out.println("当前线程：" + Thread.currentThread().getName() + "为子线程，第：" + (i + 1) + "次运行!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        subFlag = false;
        notify();
    }

    public static void main(String[] args) {
        final Test test = new Test();
        //子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 3; i++){
                    test.subMethod();
                }
            }
        }).start();

        //主线程
        for(int i = 0; i < 3; i++){
            test.mainMethod();
        }
    }
}
