package com.sgg.Thread_Learn;


class Clerk{//店员
    private int productnum=0;//产品的数量

    //增加产品数量的方法
    public synchronized void addProduct(){
        if (productnum>=20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productnum++;
        System.out.println(Thread.currentThread().getName()+"生产了第"+productnum+"产品");
        notify();
    }

    //减少产品数量的方法
    public synchronized void minusProduct(){

        if (productnum<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+"消费了第"+productnum+"产品");
        productnum--;
        notify();
    }
}

class Producer extends Thread{//生产者
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("生产者开始生产产品...");

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProduct();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("消费者开始消费产品...");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.minusProduct();

        }
    }//消费者


}

public class ProduceConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer pro1 = new Producer(clerk);
        Customer cus1 = new Customer(clerk);
        Customer cus2 = new Customer(clerk);

        pro1.setName("生产者一");
        cus1.setName("消费者一");
        cus2.setName("消费者二");

        pro1.start();
        cus1.start();
        cus2.start();
    }
}
