package Net_study02.TCP_Study;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接client accept()
 * 3、操作：输入输出流操作 （TCP直接用字节流进行传输）
 * 4、释放资源
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接client accept()
        Socket client = server.accept(); //这里可用浏览器进行检测，输入网址http://localhost:8888即可
        System.out.println("一个客户端请求了连接");
        //3、操作：输入输出流操作
        /*
        服务器端是接收数据，直接返回一个输出流，建议使用DataInputStream
         */
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        //4、释放资源
        dis.close();
        client.close();

        server.close(); //服务器一般不用关
    }
}
