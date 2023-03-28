package com.sgg.Thread_Learn;


//使用两个线程打印1-100
//wait()
//notify()唤一个优先级最高的线程
//notifyall()唤醒所有线程
//1.这三个方法必须在同步代码块里面     2.这三个调用者必须是同步监视器
class PrintNumber implements Runnable {

    private int number=1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if(number<=100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    //线程一旦执行此方法，就进入等待状态。同时会释放对同步监视器的调用
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}

public class PrintNumberTest {
    public static void main(String[] args) {
        PrintNumber printNumberTest = new PrintNumber();

        Thread t1 = new Thread(printNumberTest, "线程一");
        Thread t2 = new Thread(printNumberTest, "线程二");

        t1.start();
        t2.start();
    }
}
