package com.sgg.internet;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//文本通信
public class TcpTest1 {
    @Test
    public void clinet(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //创建socket
            InetAddress byName = InetAddress.getByName("192.168.62.222");
            int port=8989;
            socket = new Socket(byName, port);

            //发送数据
            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket !=null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream !=null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //服务端
    @Test
    public void server(){
        ServerSocket serverSocket = null;
        Socket accept = null; //阻塞式的方法
        InputStream inputStream = null;
        try {
            //创建Serversocket
            int port=8989;
            serverSocket = new ServerSocket(port);

            //调用accept(),接收客户端的socket
            accept = serverSocket.accept();
            System.out.println("服务端已开启");
            System.out.println("收到了来自"+accept.getInetAddress().getHostAddress()+"的数据");
            //接收数据
            inputStream = accept.getInputStream();
            byte[] bytes = new byte[3];
            int len;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();//内部维护一个byte[]
            while((len=inputStream.read(bytes))!=-1){
//                String s = new String(bytes, 0, len);
//                System.out.println(s);

                byteArrayOutputStream.write(bytes,0,len);
            }
            System.out.println("\n数据接收完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (serverSocket!=null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream!=null){
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(serverSocket!=null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
