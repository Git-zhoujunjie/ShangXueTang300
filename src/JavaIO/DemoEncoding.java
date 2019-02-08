package JavaIO;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class DemoEncoding {
   // public
   public static void main(String[] args) throws UnsupportedEncodingException {
       String str = "周将";

       byte[] bytes = str.getBytes();
       System.out.println(bytes.length);
       byte[] bytes2 = str.getBytes("gbk");
       System.out.println(bytes2.length);
       byte[] bytes3 = str.getBytes("utf16");
       System.out.println(bytes3.length);
   }
}
