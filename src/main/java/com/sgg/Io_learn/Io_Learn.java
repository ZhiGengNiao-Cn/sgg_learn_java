package com.sgg.Io_learn;

import java.io.*;

//FileReader \ FileWriter的使用
public class Io_Learn {
    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        FileWriter fileWriter = new FileWriter(file);
    }

    public void test1(){

    }
}
