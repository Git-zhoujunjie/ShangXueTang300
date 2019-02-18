package BuildServer.ServerStudy03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：加入servlet，解耦业务代码
 *
 *
 */
public class Server06 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server06 server = new Server06();
        server.start();
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

            //封装了请求信息
            Request request = new Request(client);
            //封装了响应信息
            Response response = new Response(client); //注意这里不能直接用空构造器，因此需要将空构造器私有化
            Servlet servlet = null;

            String url = request.getUri();
            if(url.equals("login")){
                servlet = new LoginServlet();
            }else if(url.equals("reg")){
                servlet = new RegisterServlet();
            }else{
                //新页面
            }
            //返回内容

            servlet.service(request,response);
            //向浏览器推送服务
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
