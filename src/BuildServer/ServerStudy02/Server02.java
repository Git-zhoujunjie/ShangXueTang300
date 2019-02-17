package BuildServer.ServerStudy02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：返回响应协议
 */
public class Server02 {
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server02 server01 = new Server02();
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
            InputStream is = client.getInputStream();
            byte[] flush = new byte[1024 * 10];
            int len = is.read(flush);
            String requestInfo = new String(flush,0,len);
            System.out.println(requestInfo);

            //返回内容
            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("shsxt server终于回来了。。");
            content.append("</body>");
            content.append("</html>");
            int size = content.toString().getBytes().length;//注意这里一定是字节数的长度

            //协议头格式（一定要规范）
            StringBuilder responseInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";
            //返回相应协议
            //1、响应行:HTTP/1.1 200 OK
            responseInfo.append("HTTP/1.1").append(blank).
                    append(200).append(blank).append("OK").append(CRLF);
            //2、响应头(最后一行存在空行)
            /*
            Date:
            Server:shsxt Server/0.0.1;charset=GBK
            Content-type:text/html
            Content-length:
             */
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html").append(CRLF);
            responseInfo.append("Content-length:").append(size).append(CRLF);
            responseInfo.append(CRLF); //存在空行
            //3、正文
            responseInfo.append(content.toString());

            //TCP传输，传输字符串可用BufferedWriter流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString(),0,responseInfo.toString().length());
            bw.flush();

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
