package Net_study02.Chat04;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  手写一个在线聊天室
 *  实现多个用户可以正常收发多条信息
 *  问题：其他客户必须等待当前用户退出才能收发信息
 *   目标：使用多线程实现多个用户可以同时正常收发多条信息
 *
 *  目标：用容器实现群聊：即一个人可发送消息给其他人
 */
public class TMutilClient {
    public static void main(String[] args) throws IOException {

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        System.out.println("----Client----");
        System.out.println("请输入用户名：");
        //为每个用户设置名字，先传一个名称给服务器
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();


        new Thread(new ClientSend(client,name)).start();
        new Thread(new ClientReceive(client)).start();


    }
}
