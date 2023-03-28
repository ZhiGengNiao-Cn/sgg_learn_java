package com.sgg.Thread_Learn;

class window1 implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true)
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"：  买票，票号为：  "+ticket);
                ticket--;
            }else {
                break;
            }

    }
}

public class Runnable_Demo {
    public static void main(String[] args) {
        window1 w=new window1();

        Thread w1=new Thread(w);
        Thread w2=new Thread(w);
        Thread w3=new Thread(w);

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
