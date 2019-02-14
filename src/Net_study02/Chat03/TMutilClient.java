package Net_study02.Chat03;

import java.io.*;
import java.net.Socket;

/**
 *  手写一个在线聊天室
 *  实现多个用户可以正常收发多条信息
 *  问题：其他客户必须等待当前用户退出才能收发信息
 *   目标：使用多线程实现多个用户可以同时正常收发多条信息
 *   问题：
 *  * 1、线程写在lambda表达式中不好维护
 *  * 2、客户端读写没有分开，必须先写后读
 *  *
 *  * 解决问题2
 *  * 客户端读写分开写
 */
public class TMutilClient {
    public static void main(String[] args) throws IOException {

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        System.out.println("----Client----");

        new Thread(new ClientSend(client)).start();
        new Thread(new ClientReceive(client)).start();


    }
}
