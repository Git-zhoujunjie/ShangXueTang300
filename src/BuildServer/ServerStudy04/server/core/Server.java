package BuildServer.ServerStudy04.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：加入多线程，加入分发器
 **
 */
public class Server {
    private ServerSocket serverSocket;
    private boolean isRunning ;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("启动服务出现错误");
        }

    }
    //接受连接请求
    public void receive(){
        while(isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("一个客户端建立了连接。。。");

                new Thread(new Dispatcher(client)).start();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端连接出现错误");
                stop();
            }
        }
    }
    //关闭服务
    public void stop(){
        try {
            isRunning = false;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器已停止。。。");
        }
    }
}
