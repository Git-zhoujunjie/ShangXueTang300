package Net_study02.Chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 手写一个在线聊天室
 * 服务端：相当于一个转发器，转发客户所发送的内容
 * 目标：使用多线程实现多个用户可以同时正常收发多条信息
 *
 * 问题：
 * 1、线程写在lambda表达式中不好维护
 * 2、客户端读写没有分开，必须先写后读
 */
public class TMultiServer {
    public static void main(String[] args) throws IOException {
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接client accept()
        while(true) {
            new Thread(() -> { //此处多线程，可以实现监听多个客户端，让客户端同时通信
                boolean isRunning = true;
                Socket client = null; //这里可用浏览器进行检测，输入网址http://localhost:8888即可
                try {
                    client = server.accept();

                    System.out.println("一个客户端请求了连接");
                    //3、操作：输入输出流操作

                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    //转发
                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                    //循环体用于不停地接收和发送消息

                    while (isRunning) {
                        String msg = dis.readUTF();
                        dos.writeUTF(msg);
                        dos.flush();
                    }
                    if(null != dos) {
                        dos.close();
                    }
                    if(null != dis) {
                        dis.close();
                    }
                    if(null != client) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    isRunning = false;
                }
            }).start();

            //4、释放资源

        }
        //server.close(); //服务器一般不用关
    }
}
