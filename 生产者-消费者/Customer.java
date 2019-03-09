package com.wang.demo.produce;

/**
 * @Auther: wl
 * @Date: 2019/3/9 09:14
 * @Description:
 */
public class Customer implements Runnable {

    private Repertory repertory;

    public Customer() {
    }

    public Customer(Repertory repertory) {
        this.repertory = repertory;
    }

    @Override
    public void run() {
       while (true){
           try {
               Thread.sleep(2000);
               repertory.customer();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
    }
}
