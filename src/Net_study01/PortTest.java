package Net_study01;

import java.net.InetSocketAddress;

/**
 * 端口：
 * 1、区分软件
 * 2、长度为两个字节 0-65535 TCP和UDP相互独立
 * 3、同一个协议点端口不能冲突
 * 4、定义端口建议越大越好，1024以下为通用端口
 *
 * 构造器：
 *
 */
public class PortTest {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress2.getAddress());
        System.out.println(socketAddress2.getPort());

    }
}
