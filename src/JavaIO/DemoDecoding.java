package JavaIO;

import java.io.UnsupportedEncodingException;

/**
 * 测试解码
 * 乱码原因：1.长度不匹配
 * 2.解码格式与编码格式不匹配
 */
public class DemoDecoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "人终有一死a";


        byte[] bytes = str.getBytes();
        //    public String(byte bytes[], int offset, int length, Charset charset) {
        String str2 = new String(bytes,0,bytes.length,"utf8");
        System.out.println(str2);
        String str5 = new String(bytes,0,bytes.length-2,"utf8");
        System.out.println(str5);
        String str3 = new String(bytes,0,bytes.length,"gbk");
        System.out.println(str3);
        String str4 = new String(bytes,0,bytes.length,"utf16");
        System.out.println(str4);
    }
}
