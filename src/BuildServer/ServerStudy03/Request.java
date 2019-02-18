package BuildServer.ServerStudy03;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.*;

/**
 * 封装请求协议：封装请求参数为map
 */
public class Request {
    private String requestInfo; //请求协议内容
    private String method; //请求方法
    private String uri; //请求uri
    private String queryStr; //请求参数
    private final String CRLF = "\r\n";

    private Map<String, List<String>> parameterMap;  //用map存储请求参数

    public Request(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request(InputStream is){
        parameterMap = new HashMap<>();

        byte[] flush = new byte[1024 * 10];
        int len = 0;
        try {
            len = is.read(flush);
            this.requestInfo = new String(flush,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //分解字符串
        parseRequestInfo();
    }

    /**
     * 解析请求协议信息
     * GET /login.html?uname=aaaa&pwd=shsxt HTTP/1.1
     * POST /index.html HTTP/1.1
     */
    private void parseRequestInfo(){
        System.out.println(this.requestInfo);
        //1、获取请求方法method，即GET 和POST
        this.method = this.requestInfo.substring(0,this.requestInfo.indexOf("/")).toLowerCase().trim();
        System.out.println(method);
        //2、获取uri
        int startIdx = this.requestInfo.indexOf("/")+1;
        int endIdx = this.requestInfo.indexOf("HTTP");
        this.uri = this.requestInfo.substring(startIdx,endIdx).trim();

        //3、根据？的位置分割uri和请求参数queryStr
        int queryIdx = this.requestInfo.indexOf("?");
        if(queryIdx>0){  //表示存在请求参数
            String[] urlArray = this.uri.split("\\?");
            this.uri = urlArray[0].trim();
            this.queryStr = urlArray[1].trim();
        }
        System.out.println(uri);
        //System.out.println(queryStr);

        //4、获取请求参数queryStr
        //若是GET方式，则上述已经获取
        //若是POST方式，则可能在请求体中，也可能同时在uri和请求体中
        if(this.method.equals("post")){
            int idx = this.requestInfo.lastIndexOf(CRLF);
            if(null==queryStr) {
                this.queryStr = this.requestInfo.substring(idx).trim();
            }else{
                this.queryStr += "&" + this.requestInfo.substring(idx).trim();
            }
        }
        queryStr = (queryStr==null)?"":queryStr;
        System.out.println(queryStr);

        convertMap();
    }

    /**
     *处理请求参数为map，fav=1&fav=2&uname=sxt&age=18&other=
     */
    private void convertMap(){
        //1、分割字符串
        String[] keyValues = queryStr.split("&");
        for(String s:keyValues){
            String[] kv = s.split("=");
            kv = Arrays.copyOf(kv,2);  //保证kv长度为2

            String key = kv[0];
            String value = kv[1]==null?null:decode(kv[1],"utf-8");

            if(!parameterMap.containsKey(key)){  //首次找到key时需要新建一个list
                parameterMap.put(key,new ArrayList<>());
            }
            parameterMap.get(key).add(value);
        }
    }

    //这里返回数组，方便后续操作
    public String[] getValues(String key){
        if(parameterMap.get(key)==null || parameterMap.get(key).size()<1){
            return null;
        }
        return parameterMap.get(key).toArray(new String[0]);//new String[0]表示设置数据类型
    }
    //返回单个值
    public String getValue(String key){
        return getValues(key)[0];
    }

    /**
     * 处理中文乱码问题
     * @param value
     * @param enc
     * @return
     */
    private String decode(String value,String enc){
        try {
            return java.net.URLDecoder.decode(value,enc); //字符类型转换
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getQueryStr() {
        return queryStr;
    }
}
