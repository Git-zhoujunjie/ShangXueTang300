package Net_study02.TCP_Study;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现多个客户端同时请求登录服务端
 * 熟悉流程
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接client accept()
 * 3、操作：输入输出流操作 （TCP直接用字节流进行传输）
 * 4、释放资源
 *
 */
public class LoginMultiServer {
    public static void main(String[] args) throws Exception {
        System.out.println("----服务端-----");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接client accept(),进行连续接收
        boolean flag = true;
        while (flag) {
            Socket client = server.accept();
            System.out.println("一个客户端请求了连接");
            //多线程实现同时请求
           new Thread(new Channel(client)).start();
        }
        server.close(); //服务器一般不用关
    }

    //多线程
    static class Channel implements Runnable {
        private ObjectInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        public Channel(Socket client) {
            this.client = client;
            init();
        }

        private void init(){
            try {
                dis = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();

                release(); //出现异常关闭服客户端
            }

        }

        private Object receive(){
            Object user;

            try {
                user = dis.readObject();
                return user;

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        private void Send(Object user){
            if (user instanceof User) {
                User u = (User) user;
                System.out.println(u.getUname() + "-->" + u.getUpwd());
                //服务端给客户端返回信息
                //DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                //判断：
                try {
                    if (!u.getUname().equals("老周") || !u.getUpwd().equals("12345asdf")) {

                        dos.writeUTF("用户名或密码错误！");


                    } else {
                        dos.writeUTF("登录成功！");
                    }
                    dos.flush();
                   // dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        private void release(){
            //4、释放资源
            try {
                if(null != dos) {
                    dos.close();
                }
                if(null != dis) {
                    dis.close();
                }
                if(null != client){
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        @Override
        public void run() {
            // Socket client = server.accept(); //这里可用浏览器进行检测，输入网址http://localhost:8888即可

            //3、操作：输入输出流操作
            /*
            服务器端是接收数据，直接返回一个输出流，接收User对象
             */
            //ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));

            Object user = receive(); //接收数据的方法

            Send(user);
            release();

            //client.close();
        }
    }
}
