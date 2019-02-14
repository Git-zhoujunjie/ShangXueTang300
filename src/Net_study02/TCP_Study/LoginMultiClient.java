package Net_study02.TCP_Study;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.Socket;

/**
 * 实现多个客户端同时请求登录服务端
 * 熟悉流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 *
 */
public class LoginMultiClient {
    public static void main(String[] args) throws IOException {


        System.out.println("----客户端-----");

        //1、建立连接：使用Socket创建客户端 + 服务的地址和端口
        Socket client = new Socket("localhost",8888);

        Send send = new Send(client);
        System.out.println("用户名："+send.uname);
        System.out.println("密码："+send.upsw);
        send.sendMsg();

        new Receive(client).receiveMsg();
        // 3、释放资源

        client.close();
    }

    static class Send {

        // 2、操作：输入输出流操作
        /*
        客户端用于发送数据，实质是一个输出流
        这里发送User对象
         */
        ObjectOutputStream obj;
        BufferedReader br;
        String uname;
        String upsw;
        User user;

        public Send(Socket client) {
            try {
                obj = new ObjectOutputStream(
                        new BufferedOutputStream(client.getOutputStream()));
                br = new BufferedReader(new InputStreamReader(System.in));

                uname = br.readLine();
                upsw = br.readLine();
                user = new User(uname,upsw);

            }catch (IOException e){
                e.printStackTrace();
                release();
            }
        }

        public void sendMsg() {
            try {
                obj.writeObject(this.user);
                obj.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void release(){
            try {
                obj.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    static class Receive{

        //接收服务端返回的信息
        DataInputStream dis;
        public Receive(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());

            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        public void receiveMsg() {
            try {
                System.out.println(dis.readUTF());
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
