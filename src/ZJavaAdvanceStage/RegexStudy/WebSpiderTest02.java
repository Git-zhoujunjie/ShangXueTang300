package ZJavaAdvanceStage.RegexStudy;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取一个网站中的图片并保存
 */
public class WebSpiderTest02 {
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
    public static List<String> getUrlFromCode(String code, String regexStr) {
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile(regexStr);
        Matcher m = p.matcher(code);

        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }

    /**
     * 从URL中读取文件并保存
     * @param url
     */
    public static void getFileFromUrl(String url,String dirPath) {

        String fileName = dirPath + url.substring(url.lastIndexOf("/")); //最后一个/后面的内容为文件名

        try (OutputStream os = new FileOutputStream(new File(fileName));  //新建一个输出流
             InputStream is = new BufferedInputStream(new URL(url).openStream());  //从URL中获取字节流
        ) {

            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush,0,len);
            }
            os.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void result(String url,String regexStr,String charset,String dirPath){
        File file = new File(dirPath);
        if(!file.exists()){
            file.mkdir(); //在当前项目中新建一个目录
        }else return;

        String code = getCodeFromUrl(url,charset);
        List<String> list = getUrlFromCode(code,regexStr);
        System.out.println(list.size());
        for(String s:list){
            System.out.println(s);
            getFileFromUrl(s,dirPath);
        }
    }

    public static void main(String[] args) {
//        String url = "https://tieba.baidu.com/p/5510453003?red_tag=2361432215";
//        //System.out.println(getCodFromUrl(url,"utf-8"));
//        String regexStr = "src=\"(https://i.+?jpg)\"";//获取超链接整个内容

//        String url = "http://acg17.com/18718.html";
//        //System.out.println(getCodeFromUrl(url,"utf-8"));
//        String regexStr = "";
//
//        String code = getCodeFromUrl(url,"utf-8");
//        List<String> list = getUrlFromCode(code,regexStr);
//        System.out.println(list.size());
//        for(String s:list){
//            System.out.println(s);
//            getFileFromUrl(s,"Fate2");
//        }


        result("https://tieba.baidu.com/p/5510453003?red_tag=2361432215",
                "src=\"(https://i.+?jpg)\"","utf-8","Fate2");

        result("http://acg17.com/18718.html","https:[/\\w:.?&_]+?jpg",
                "utf-8","Fate3");
    }
}
