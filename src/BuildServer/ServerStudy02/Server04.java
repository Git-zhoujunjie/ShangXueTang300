package BuildServer.ServerStudy02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：封装请求信息
 * 获取请求参数
 *
 */
public class Server04 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server04 server01 = new Server04();
        server01.start();
    }

    //启动服务
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("启动服务出现错误");
        }

    }
    //接受连接请求
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接。。。");

            //获取http请求协议
            //因为http协议底层采用TCP协议实现，因此可以直接用之前TCP获取数据的方式获取请求协议
            Request01 request01 = new Request01(client);

            Response response = new Response(client); //注意这里不能直接用空构造器，因此需要将空构造器私有化
            //返回内容
            //StringBuilder content = new StringBuilder();
            response.println("<html>");
            response.println("<head>");
            response.println("<title>");
            response.println("服务器响应成功");
            response.println("</title>");
            response.println("</head>");
            response.println("<body>");
            response.println("shsxt server终于回来了。。");
            response.println("</body>");
            response.println("</html>");
            //这里先添加了内容信息，因此len也发生了变化

            //只关注了内容和状态码
            response.pushToBrowser(200);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接出现错误");
        }
    }
    //关闭服务
    public void stop(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭服务出现错误");
        }
    }
}
