package Net_study01;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址：定位一个节点：本机、路由等
 * InetAddress:
 * 1、getLocalHost
 * 2、getByName：
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress()); //返回本机IP
        System.out.println(addr.getHostName()); //输出本机名

        addr = InetAddress.getByName("www.shsxt.com");
        System.out.println(addr.getHostAddress()); //返回ip
        System.out.println(addr.getHostName()); //输出www.shsxt.com

    }
}
