package Net_study02.Chat02;

import java.io.*;
import java.net.Socket;

/**
 * 手写一个在线聊天室
 *  实现多个用户可以正常收发多条信息
 *
 *  //问题：其他客户必须等待当前用户退出才能收发信息
 *   * 目标：使用多线程实现多个用户可以同时正常收发多条信息
 */
public class TMutilClient {
    public static void main(String[] args) throws IOException {

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        // 2、操作：输入输出流操作
        /*
        客户端用于发送数据，实质是一个输出流，建议使用DataOutputStream
         */
        //发送消息
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        //循环体用于不停地接收和发送消息
        boolean isRunning = true;
        while (isRunning) {


            String msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
            //接收消息
            msg = dis.readUTF();
            System.out.println(msg);
            // 3、释放资源
        }
        dis.close();
        dos.close();
        client.close();

    }
}
