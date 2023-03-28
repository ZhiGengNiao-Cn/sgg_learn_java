package com.sgg.Thread_Learn;


class window extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while (true)
            if (ticket>0){
                System.out.println(Thread.currentThread().getName()+"：买票，票号为："+ticket);
                ticket--;
            }else {
                break;
            }

    }
}

public class Thread_Demo {
    public static void main(String[] args) {
        window window1=new window();
        window window2=new window();
        window window3=new window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
