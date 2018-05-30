package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Tainy
 * @date 2018/5/30 13:51
 */
public class TimerTaskTest extends TimerTask{

    private static volatile int count = 0 ;

    @Override
    public void run() {
        count = (count + 1)%2;
        System.out.println(2 + 2 * count + "秒的执行 ");
        new Timer().schedule(new TimerTaskTest(), 2000 + 2000 * count);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTaskTest(), 2000 + 2000 * count);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
