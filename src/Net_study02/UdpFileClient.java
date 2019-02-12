package Net_study02;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 利用UDP协议实现基本类型的传输
 * 发送端
 *    1、使用DatagramSocket 指定端口 创建发送端
 *  * 2、准备数据，转成字节数组
 *  * 3、封装成DatagramPacket包裹，指定目的地
 *  * 4、发送包裹send(DatagramPacket p)
 *  * 5、释放资源
 *
 *  这里实现文件（图片）的发送
 */

public class UdpFileClient {
    public static void main(String[] args) throws Exception{
        System.out.println("（图片的发送）发送端启动中。。。。。");

        DatagramSocket client = new DatagramSocket(30000);
        byte[] datas = new byte[1024];

        try(
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(new File("Fate/YunTorrentFile.ico")));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ) {
            int len = -1;
            while((len=bis.read(datas))!=-1){
                bos.write(datas,0,len);  //写入到字节流
            }
            bos.flush();

            datas = bos.toByteArray();
        }
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",33333));
        client.send(packet);

        client.close();
    }
}
