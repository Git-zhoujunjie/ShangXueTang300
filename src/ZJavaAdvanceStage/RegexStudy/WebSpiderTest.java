package ZJavaAdvanceStage.RegexStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实现一个网络爬虫的信息搜索
 * 即从一个网页源码中获取到全部的URL
 */
public class WebSpiderTest {
    /**
     * 从给定的URL中获取网页源代码
     * @param urlStr
     * @param charset
     * @return
     */
    public static String getCodeFromUrl(String urlStr, String charset) {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), charset));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                sb.append(msg);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * 通过正则表达式获取网页中的指定信息
     * @param code
     * @param regexStr
     * @return
     */
    public static List<String> getUrlFromCode(String code, String regexStr){
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(code);

        while(m.find()){
            list.add(m.group(1)); //原信息分为三组，这里取出括号中的信息
        }
        return list;
    }
    public static void main(String[] args) {
        String url = "https://www.163.com";
        //String regexStr = "<a[\\s\\S]+?</a>";//获取超链接整个内容
        //String regexStr = "href=\"(.+?)\""; //获取超链接网址，加括号后括号内分组为纯网址
        String regexStr = "href=\"([\\w:/&.=?]+?)\"";  //进一步去掉多余的信息

        String code = getCodeFromUrl(url,"gbk");
        List<String> list = getUrlFromCode(code,regexStr);
        System.out.println(list.size());
        for(String s:list){
            System.out.println(s);
        }
    }
}
