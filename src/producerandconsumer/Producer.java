package producerandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 *
 * @author Tainy
 * @date 2020-03-02 14:46
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> queue){
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(1000);
                blockingQueue.add(produce());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Integer produce(){
        Integer n = new Random().nextInt();
        System.out.println("Thread:" + Thread.currentThread().getId() + " produce:" + n);
        return n;
    }

}
