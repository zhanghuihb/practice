package producerandconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author Tainy
 * @date 2020-03-02 14:50
 */
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(5000);
                consume(blockingQueue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume(Integer n){
        System.out.println("Thread:" + Thread.currentThread().getId() + " consume:" + n);
    }
}
