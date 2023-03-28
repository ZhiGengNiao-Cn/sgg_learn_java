package com.sgg.Thread_Learn;



public class test{
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        for (int i=0;i<=100;i++){
            if (i%2==1){
                System.out.println(Thread.currentThread().getPriority()+"main");
            }
        }
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getPriority()+"thread");
            }
        }
    }
}
