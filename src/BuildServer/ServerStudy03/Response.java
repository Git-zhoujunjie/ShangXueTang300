package BuildServer.ServerStudy03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * 目标：封装响应信息
 * 1、内容可以动态添加
 * 2、关注状态码，拼接好响应的协议信息
 *
 */
public class Response {

    private BufferedWriter bw;
    //正文
    private StringBuilder content;
    //协议头
    private StringBuilder headInfo;
    //正文字节长度
    private int len;

    private final String BLANK = " ";  //常量不变化
    private final String CRLF = "\r\n";

    private Response(){
        content = new StringBuilder();
        headInfo = new StringBuilder();
        len = 0;
    }
    public Response(Socket client) {
        this(); //调用无参构造器
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            headInfo = null;
        }

    }
    public Response(OutputStream os){
        this(); //调用无参构造器
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    //构建协议头信息
    private void createHeadInfo(int code){
        //协议头格式（一定要规范）
        //1、响应行:  通过状态码构建响应的协议头
        switch (code) {
            case 200: headInfo.append("HTTP/1.1").append(BLANK).
                    append(200).append(BLANK).append("OK").append(CRLF);
            break;
            case 404: headInfo.append("HTTP/1.1").append(BLANK).
                    append(404).append(BLANK).append("NOT FOUND").append(CRLF);
            break;
            case 505: headInfo.append("HTTP/1.1").append(BLANK).
                    append(505).append(BLANK).append("SERVER ERROR").append(CRLF);
            break;

        }
        //2、响应头(最后一行存在空行)
            /*
            Date:
            Server:shsxt Server/0.0.1;charset=GBK
            Content-type:text/html
            Content-length:
             */
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF); //存在空行
        //3、正文
        headInfo.append(content.toString());
    }

    //动态构建内容 采用流模式
    public Response print(String msg){
        content.append(msg);
        len += msg.getBytes().length;
        return this;
    }
    public Response println(String msg) {
        content.append(msg).append(CRLF);
        len += (msg + CRLF).getBytes().length;
        return this;
    }

    //推送响应信息
    public void pushToBrowser(int code) throws IOException {
        if(headInfo==null) code = 404;

        createHeadInfo(code);
        bw.append(headInfo);
        bw.append(content);

        bw.flush();
    }
}
