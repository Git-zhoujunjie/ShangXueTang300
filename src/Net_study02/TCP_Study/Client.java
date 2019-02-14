package Net_study02.TCP_Study;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 *
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8888);
        // 2、操作：输入输出流操作
        /*
        客户端用于发送数据，实质是一个输出流，建议使用DataOutputStream
         */
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("hello");
        dos.flush();
        // 3、释放资源
        dos.close();
        client.close();
    }
}
