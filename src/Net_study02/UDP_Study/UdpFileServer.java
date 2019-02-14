package Net_study02.UDP_Study;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 利用UDP协议实现基本类型的传输
 * 接收端
 *  * 1、使用DatagramSocket 指定端口 创建接收端
 *  * 2、准备容器，封装成DatagramPacket包裹
 *  * 3、阻塞式接收包裹receive(DatagramPacket p)
 *  * 4、分析数据
 *  *      byte[] getData()
 *  *             getLength()
 *  * 5、释放资源
 *
 *  这里实现文件的传输
 */

public class UdpFileServer {
    public static void main(String[] args) throws Exception{
        System.out.println("（图片的接收）接收端启动中。。。。。");
        DatagramSocket server = new DatagramSocket(33333);
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);

        try (
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(new File("Fate/copy.ico")));
                ByteArrayInputStream bis = new ByteArrayInputStream(packet.getData());
        ) {
            byte[] temp = new byte[3];
            int len = -1;
            while((len = bis.read(temp))!=-1) {
                bos.write(temp, 0, temp.length);
            }
            bos.flush();
        }
        server.close();
    }
}
