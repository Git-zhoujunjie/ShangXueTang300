package Net_study02.Chat03;

import java.io.*;
import java.net.Socket;

/**
 * 使用多线程封装客户端发送消息
 */
public class ClientSend implements Runnable{
    private BufferedReader br ;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning = true;
    private String msg = "";

    public ClientSend(Socket client){
        try {
            this.client = client;
            br= new BufferedReader(new InputStreamReader(System.in));
            dos = new DataOutputStream(this.client.getOutputStream());

        } catch (IOException e) {
            System.out.println("构造出错01");
            release();
        }
    }

    private String getStrFromCon(){
        try {
            this.msg = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
    //发送消息
    private void Send(){
        try {
            dos.writeUTF(this.msg);
            dos.flush();
        } catch (IOException e) {
            release();
        }
    }

    //释放资源
    private void release(){
        this.isRunning = false;
        ChatUtils.close(dos,client);
    }

    @Override
    public void run() {
        while(isRunning) {
            msg = getStrFromCon();
            //System.out.println("daying:"+msg);
            if(!msg.equals("")) {
                Send();
            }
        }
    }
}
