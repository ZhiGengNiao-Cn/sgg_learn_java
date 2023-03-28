package com.sgg.mobiletrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class ListPractice {
        public static void main(String[] args) {
                ArrayList<Integer> array=new ArrayList<>();
                LinkedList<Integer> link=new LinkedList<>();

//                long array_start = System.currentTimeMillis();
                for (int i=0;i<10;i++){
                        array.add(i);
                }
                System.out.println(array);
//                long array_end = System.currentTimeMillis();
//                System.out.println(array_end-array_start);

//                long link_start = System.currentTimeMillis();
//                for (int i=0;i<1000000;i++){
//                        link.add(i);
//                }
//                long link_end = System.currentTimeMillis();
//                System.out.println(link_end-link_start);


        }
}
