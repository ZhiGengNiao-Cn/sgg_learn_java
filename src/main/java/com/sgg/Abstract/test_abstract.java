package com.sgg.Abstract;

import com.sgg.Interface.test_interface;

public class test_abstract extends cicle_abstract{
    @Override
    public double cicle(double r) {
        pai=2;
        return r*r*pai;
    }

    @Override
    public void run() {
        System.out.println("方法一成功");
    }

    public static void main(String[] args) throws Exception{
        double r=2;
        test_abstract test=new test_abstract();
        double x=test.cicle(r);
        System.out.println(x);
        test.run();

        test_abstract1 test1=new test_abstract1();
        System.out.println(test1.cicle(r));
        test1.run();
    }
}

class test_abstract1 extends cicle_abstract{
    @Override
    public double cicle(double r) {
        return r*r*pai;
    }

    @Override
    public void run() {
        System.out.println("方法二成功");
    }
}
