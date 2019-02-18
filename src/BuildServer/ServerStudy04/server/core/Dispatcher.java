package BuildServer.ServerStudy04.server.core;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 加入分发器
 *
 * 目标：加入处理404，505和首页
 */
public class Dispatcher implements Runnable{
    private Socket client;
    private Request request;
    private Response response ;
    private Servlet servlet;

    public Dispatcher(Socket client){
        this.client = client;
        try {
            //获取请求信息
            request = new Request(client);
            //获取响应信息
            response = new Response(client);

            servlet = WebApp.getServletFromUrl(request.getUri());
        } catch (IOException e) {

            release();
        }

    }

    @Override
    public void run() {

        try {
            //首页
            if(request.getUri().equals("") || null==request.getUri()){
                InputStream is = Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("BuildServer/ServerStudy04/index.html");
                response.print(new String(is.readAllBytes()));
                response.pushToBrowser(200);
                is.close();
                return;
            }
            if (servlet != null) {
                servlet.service(request, response);
                //向浏览器推送服务
                response.pushToBrowser(200);

            } else {
                //向浏览器推送服务 错误页面
                InputStream is = Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("BuildServer/ServerStudy04/error.html");
                response.print(new String(is.readAllBytes()));
                is.close();
                response.pushToBrowser(404);

            }
        } catch (IOException e) {
            try {
                response.pushToBrowser(505);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            release();
        }

    }

    //关闭服务
    public void release(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭服务出现错误");
        }
    }
}
