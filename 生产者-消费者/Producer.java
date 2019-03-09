package com.wang.demo.produce;

/**
 * @Auther: wl
 * @Date: 2019/3/9 09:07
 * @Description: 生产者-消费者
 */
public class Producer implements Runnable{

   private Repertory repertory;

    public Producer() {
    }

    public Producer(Repertory repertory) {
        this.repertory = repertory;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                repertory.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
