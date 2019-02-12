package Net_study01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络爬虫的原理
 *
 */
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        //1、获取URL
        URL url = new URL("https://www.jd.com");
        //2、下载资源
        /*
        InputStreamReader:将字节流转换成字符流，便于处理
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
        String msg;
        while(null != (msg=br.readLine())){
            System.out.println(msg);
        }

        //3、数据分析（正则表达式）
        //4、数据处理
    }
}
