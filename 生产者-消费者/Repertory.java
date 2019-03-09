package com.wang.demo.produce;

import java.util.LinkedList;

/**
 * @Auther: wl
 * @Date: 2019/3/9 09:14
 * @Description:
 */
public class Repertory {
    //仓库大小
    private final int MAX_SIZE = 10;
    //载体
    private LinkedList<Object> list = new LinkedList<>();

    public void produce(){
        synchronized (list){
            while (list.size()+1>MAX_SIZE){
                System.out.println("生产者"+Thread.currentThread().getName()+"仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者"+Thread.currentThread().getName()+"生产一个产品，现库存"+list.size());
            list.notifyAll();
        }
    }

    public void customer(){
        synchronized (list){
            while (list.isEmpty()){
                System.out.println("消费者"+Thread.currentThread().getName()+"没东西可以消费");

            }
            list.remove();
            System.out.println("消费者"+Thread.currentThread().getName()+"正在消费一个产品，库存为"+list.size());
            list.notifyAll();
        }
    }

    public static void main(String[] args) {
        Repertory repertory = new Repertory();
        Thread  p1 = new Thread(new Producer(repertory));
        Thread  p2 = new Thread(new Producer(repertory));
        Thread  p3 = new Thread(new Producer(repertory));

        Thread  c1 = new Thread(new Customer(repertory));
        Thread  c2 = new Thread(new Customer(repertory));
        Thread  c3 = new Thread(new Customer(repertory));
        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();
        c3.start();



    }
}
