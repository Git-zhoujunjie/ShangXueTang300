package Net_study02.Chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 手写一个在线聊天室
 * 服务端：相当于一个转发器，转发客户所发送的内容
 *实现多个用户可以正常收发多条信息
 */
public class MutilServer {
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
        //转发
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        //循环体用于不停地接收和发送消息
        boolean isRunning = true;
        while (isRunning) {
            String msg = dis.readUTF();
            dos.writeUTF(msg);
            dos.flush();

        }
        //4、释放资源
        dos.close();
        dis.close();
        client.close();
        server.close(); //服务器一般不用关
    }
}
