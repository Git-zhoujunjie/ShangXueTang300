package Net_study02.TCP_Study;


import java.io.*;
import java.net.Socket;

/**
 * 文件拷贝：用TCP实现文件的传输，（文件大小无限制）
 *
 * 熟悉流程
 * 创建客户端
 * 1、建立连接：使用Socket创建客户端 + 服务的地址和端口
 * 2、操作：输入输出流操作
 * 3、释放资源
 *
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);

        try (
                InputStream is = new FileInputStream(new File("Fate/bba2.jpg"));//先将文件读入到字节流中
                OutputStream os = new BufferedOutputStream(client.getOutputStream()); //再将字节流写入到socket中
        ) {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        }
        client.close();
    }
}
