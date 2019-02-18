package BuildServer.ServerStudy02;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 封装请求协议：获取method、URI
 */
public class Request01 {
    private String requestInfo; //请求协议内容
    private String method; //请求方法
    private String uri; //请求uri
    private String queryStr; //请求参数
    private final String CRLF = "\r\n";

    public Request01(Socket client) throws IOException {
        this(client.getInputStream());
    }

    public Request01(InputStream is){
        byte[] flush = new byte[1024 * 10];
        int len = 0;
        try {
            len = is.read(flush);
            this.requestInfo = new String(flush,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        this.uri = this.requestInfo.substring(startIdx,endIdx);

        //3、根据？的位置分割uri和请求参数queryStr
        int queryIdx = this.requestInfo.indexOf("?");
        if(queryIdx>0){  //表示存在请求参数
            String[] urlArray = this.uri.split("\\?");
            this.uri = urlArray[0];
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
    }
}
