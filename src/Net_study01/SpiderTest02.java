package Net_study01;

/**
 * 网络爬虫原理 + 模拟浏览器
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpiderTest02 {
    public static void main(String[] args) throws Exception{

        //1、获取URL
        //想要直接获取点评网点资源，这样是不可行的（返回403），但到浏览器中可以访问网页，因此这里需要模拟浏览器进行获取
        URL url = new URL("https://www.dianping.com");
        //2、下载资源
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        /*
        InputStreamReader:将字节流转换成字符流，便于处理
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String msg;
        while (null != (msg = br.readLine())) {
            System.out.println(msg);
        }

        //3、数据分析（正则表达式）
        //4、数据处理

    }
}
