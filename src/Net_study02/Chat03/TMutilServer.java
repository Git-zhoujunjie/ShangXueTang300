package Net_study02.Chat03;

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
 *
 * 解决问题1：
 * 封装代码，易于维护
 *
 */
public class TMutilServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接client accept()
        while(true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
        //server.close(); //服务器一般不用关
    }
}
//一个Channel相当于一个客户端
class Channel implements Runnable{
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning ;

    public Channel(Socket client){
        try {
            this.isRunning = true;
            this.client = client;
            dis = new DataInputStream(this.client.getInputStream());
            dos = new DataOutputStream(this.client.getOutputStream());
        } catch (IOException e) {
            System.out.println("构造出错01");
            release();
        }
    }

    //接收消息
    private String receive(){
        //接收消息就是从流中读取
        String msg = "";
        try {
            msg = this.dis.readUTF();
        } catch (IOException e) {
            release();
        }
        return msg;
    }
    //发送消息
    private void Send(String msg){
        //发送消息就是将接收过来的消息写入到流中
        try {
            this.dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }
    //释放资源
    public void release(){
        isRunning = false;
        ChatUtils.close(dos,dis,client);
    }
    @Override
    public void run() {
        while (isRunning) {
            String msg = receive();
            //当字符串为空时不发送
            if(msg.equals("")) continue;

            Send(msg);
        }
        release();
    }
}
