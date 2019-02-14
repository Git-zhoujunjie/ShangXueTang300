package Net_study02.TCP_Study;

import java.io.*;
import java.net.Socket;

/**
 * 写一个登录服务器的客户端
 * 熟悉流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 *
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        User user = new User("老周","12345asd");
        System.out.println("----客户端-----");
        System.out.println("用户名："+user.getUname());
        System.out.println("密码："+user.getUpwd());
        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8888);
        // 2、操作：输入输出流操作
        /*
        客户端用于发送数据，实质是一个输出流
        这里发送User对象
         */
        ObjectOutputStream obj = new ObjectOutputStream(
                new BufferedOutputStream(client.getOutputStream()));

        obj.writeObject(user);
        obj.flush();
        //接收服务端返回的信息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        dis.close();
        // 3、释放资源
        obj.close();
        client.close();
    }
}
