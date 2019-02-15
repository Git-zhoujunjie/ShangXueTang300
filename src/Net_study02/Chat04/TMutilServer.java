package Net_study02.Chat04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 手写一个在线聊天室
 * 服务端：相当于一个转发器，转发客户所发送的内容
 * 目标：使用多线程实现多个用户可以同时正常收发多条信息
 *
 * 目标：用容器实现群聊：即一个人可发送消息给其他人
 *
 */
public class TMutilServer {

    //并发容器，可实现边读边写，实质是将原容器复制一份，每当容器中元素更改时及时更新原内容
    private static CopyOnWriteArrayList<Channel> arrayClient = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //1、指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //2、阻塞式等待连接client accept()
        while (true) {
            Socket client = server.accept();
            Channel c = new Channel(client);
            arrayClient.add(c); //每一个客户端连接服务器便加入容器
            System.out.println("一个客户端建立了连接");
            new Thread(c).start();
        }
        //server.close(); //服务器一般不用关
    }


    //一个Channel相当于一个客户端
    static class Channel implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            try {
                this.isRunning = true;
                this.client = client;
                dis = new DataInputStream(this.client.getInputStream());
                dos = new DataOutputStream(this.client.getOutputStream());

                this.name = receive(); //接收客户端的姓名
                Send(this.name+"--欢迎来到zjj聊天室！"); //向原发送者表示欢迎
                SendOthers(this.name+"加入到聊天室！",true);//向其他人发送通知,true表示系统消息

            } catch (IOException e) {
                System.out.println("构造出错01");
                release();
            }
        }

        //接收消息
        private String receive() {
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
        private void Send(String msg) {

            //遍历容器，将消息发送给除自己client之外的其他client
            try {
                this.dos.writeUTF(msg);
                dos.flush();

            } catch (IOException e) {
                release();
            }
        }
        //发送群聊消息、发送私聊消息
        private void SendOthers(String msg,boolean flag) {
            //定义私聊信息格式 @NAME:msg
            if (msg.startsWith("@")) {   //私聊
                String _name = msg.substring(1, msg.indexOf(":"));
                String _msg = msg.substring(msg.indexOf(":") + 1);

                for (Channel c : arrayClient) {
                    if (c.name.equals(_name)) {
                        c.Send(this.name + "悄悄的对你说：" + _msg);
                        break;
                    }else{
                        this.Send("当前用户不存在！");
                    }
                }
            } else {   //群聊
                {
                    //遍历容器，将消息发送给除自己client之外的其他client
                    for (Channel c : arrayClient) {
                        if (c == this) continue; //代表自身
                        if (flag) {  //系统消息
                            c.Send(msg);
                        } else {  //非系统消息
                            c.Send(this.name + "对其他人说：" + msg); //发给其他人
                        }
                    }
                }
            }
        }

        //释放资源
        public void release() {
            isRunning = false;
            ChatUtils.close(dos, dis, client);
            arrayClient.remove(this); //退出
            SendOthers(this.name+"离开了大家庭。。。",true);
        }

        @Override
        public void run() {
            while (isRunning) {
                String msg = receive();
                //当字符串为空时不发送
                if (msg.equals("")) continue;
                SendOthers(msg,false);   //false表示非系统消息
            }
            //release();
        }
    }

}