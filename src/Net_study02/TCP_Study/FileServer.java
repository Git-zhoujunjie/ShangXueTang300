package Net_study02.TCP_Study;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 用TCP实现文件的传输，（文件大小无限制）
 * 熟悉流程
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接client accept()
 * 3、操作：输入输出流操作 （TCP直接用字节流进行传输）
 * 4、释放资源
 *
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();

        //获取文件
        try (
                InputStream is = new BufferedInputStream(client.getInputStream()); //先将socket中字节流读出来到is中
                OutputStream fos = new BufferedOutputStream(
                        new FileOutputStream(new File("Fate/bbacopy.jpg")));//然后将字节流写入到文件中
        ) {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                fos.write(flush, 0, len);
            }
            fos.flush();
        }
        client.close();

    }
}
