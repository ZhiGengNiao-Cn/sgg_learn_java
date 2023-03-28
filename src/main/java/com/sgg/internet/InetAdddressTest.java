package com.sgg.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdddressTest {
    public static void main(String[] args) {
        try {
            InetAddress byAddress = InetAddress.getByName("192.168.23.31");
            System.out.println(byAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
