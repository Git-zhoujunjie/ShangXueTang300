package BuildServer.ServerStudy02;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：使用ServerSocket建立与浏览器的连接，获取请求协议
 */
public class Server01 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server01 server01 = new Server01();
        server01.start();
    }

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("启动服务出现错误");
        }

    }
    //接受连接请求
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接。。。");

            //获取http请求协议
            //因为http协议底层采用TCP协议实现，因此可以直接用之前TCP获取数据的方式获取请求协议
            InputStream is = client.getInputStream();
            byte[] flush = new byte[1024 * 10];
            int len = is.read(flush);
            String requestInfo = new String(flush,0,len);
            System.out.println(requestInfo);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接出现错误");
        }
    }
    //关闭服务
    public void stop(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭服务出现错误");
        }
    }
}
