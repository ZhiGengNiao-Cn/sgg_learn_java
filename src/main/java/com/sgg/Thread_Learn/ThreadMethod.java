package com.sgg.Thread_Learn;


class mythread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<101;i++){
            if (i%2==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"  "+i);
                //获取线程优先级
    //                System.out.println(Thread.currentThread().getPriority());

            }
//            if (i%10==0){
//                this.yield();    //释放线程
//            }
        }
    }
}



public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        mythread tttt = new mythread();
        tttt.setName("线程一");
        //设置线程优先级(设置成最大)
        tttt.setPriority(Thread.MAX_PRIORITY);
        tttt.start();

        Thread.currentThread().setName("main");
        for (int i=0;i<101;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
            if (i==20){
                tttt.join();    //主线程中调用tttt线程，主线程阻塞，直到tttt线程结束后结束阻塞状态
            }
//            if (i==99){
//                tttt.stop();    //强制结束线程
//            }
        }
    }

}

