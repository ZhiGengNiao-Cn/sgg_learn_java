package com.sgg.Thread_Learn;



class myrunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==1){
                System.out.println(Thread.currentThread().getPriority()+"runnable");
            }
        }
    }
}

public class RunnableMethod {
    public static void main(String[] args) {
        myrunnable test=new myrunnable();

        Thread t1=new Thread(test);

        t1.start();
    }
}
