package BuildServer.ServerStudy03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：整合配置文件
 * 根据配置文件动态的读取类名，在进行反射获取具体的Servlet来处理业务，真正实现以不变应万变
 *
 */
public class Server07 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server07 server = new Server07();
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

            /*
            至此，即可通过更改配置文件根据URL进行创建相应的对象，执行相应的服务
             */
            Servlet servlet = WebApp.getServletFromUrl(request.getUri());
            if(servlet!=null) {
                servlet.service(request, response);
                //向浏览器推送服务
                response.pushToBrowser(200);
            }else {
                //向浏览器推送服务
                response.pushToBrowser(404);
            }

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
