package com.sgg.Interface;

public class test_interface implements cicle_interface{

    @Override
    public double cicle(double x) {
        return x*x*pai;
    }

    public static void main(String[] args) {
        test_interface a=new test_interface();
//        System.out.println(a.cicle(55));
        cicle_interface test= new cicle_interface() {
            @Override
            public double cicle(double x) {
                return x*x*pai;
            }
        };
//        System.out.println(test.cicle(1.2));


        double v = a.cicle_test(new cicle_interface() {
            @Override
            public double cicle(double x) {
                return x*x*pai;
            }
        }, 2.2);

        System.out.println(v);
    }

    public double cicle_test(cicle_interface cc,double a){
        return cc.cicle(a);
    }
}
