package Net_study02.Chat04;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 使用多线程封装客户端接收消息
 */
public class ClientReceive implements Runnable{

    private DataInputStream dis;
    private Socket client;
    private boolean isRunning = true;

    public ClientReceive(Socket client){
        try {
            this.client = client;
            dis = new DataInputStream(this.client.getInputStream());
        } catch (IOException e) {
            System.out.println("构造出错02");
            release();
        }

    }
    //接收消息
    private String Receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            release();
        }
        return msg;
    }

    //释放资源
    private void release(){
        this.isRunning = false;
        ChatUtils.close(dis,client);
    }

    @Override
    public void run() {
        while (isRunning) {
            String str = this.Receive();
            if(!str.equals("")) {
                System.out.println(str);
            }
        }
    }
}
