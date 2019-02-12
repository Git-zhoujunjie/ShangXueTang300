package Net_study01;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL:统一资源定位符，互联网三大基石之一（html,http），用于区分同一个软件的不同资源
 * 组成：
 * 1、协议 (http)
 * 2、域名、计算机 (www.baidu.com)
 * 3、端口 (80)
 * 4、请求资源 (index.html?uname=shsxt&age=18#a)
 *
 * http://www.baidu.com:80/index.html?uname=shsxt&age=18#a
 */
public class URLTest01 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        //获取四个值
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名|IP:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("资源1:"+url.getFile());
        System.out.println("资源2:"+url.getPath());

        //参数
        System.out.println(""+url.getQuery());
        //锚点
        System.out.println("锚点:"+url.getRef());
    }
}
