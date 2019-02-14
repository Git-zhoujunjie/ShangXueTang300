package Net_study02.Chat;

import java.io.*;
import java.net.Socket;

/**
 * 手写一个在线聊天室
 *  实现一个用户可以正常收发信息
 */
public class Client {
    public static void main(String[] args) throws IOException {

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost", 8888);
        // 2、操作：输入输出流操作
        /*
        客户端用于发送数据，实质是一个输出流，建议使用DataOutputStream
         */
        //发送消息

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //接收消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        // 3、释放资源

        dis.close();
        dos.close();
        client.close();

    }
}
