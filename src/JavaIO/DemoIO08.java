package JavaIO;

import java.io.*;
import java.net.URL;

/**
 * 测试 转换流
 * 1.InputStreamReader(extends Reader): 字节流转成字符流（即解码：输入字节流，然后可以进行转换成字符流）
 * 2.OutputStreamWriter(extends Writer): 字符流转成字节流（即编码：输入字符流，然后可以进行转换成字节流）
 *
 * 增加网络流输入输出
 */
public class DemoIO08 {
    public static void main(String[] args) {
        //test1();
        test3();
    }

    /**
     * 测试 System.in 和 System.out
     * System.in：控制台输入，输入的为字节流，需要转换成字符流进行处理
     * System.out：控制台输出，输出为字符流，需要转换成字节流
     */

    public static void test1(){

        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        //openStream()打开一个网络流（属于节点流，实质是字节流）
                        new URL("https://www.bilibili.com").openStream(),"utf-8"));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("bilibili.html"),"UTF-8")
            )){
            String str;
            while((str=reader.readLine())!=null){
               // System.out.println(str);
                writer.write(str);
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("输入异常！");
        }
    }

    public static void test2(){

        try(InputStream reader = new URL("http://www.baidu.com").openStream()){
            String str;
            int len = -1;
            while((len=reader.read())!=-1){
                System.out.print((char)len); //乱码原因：字节数不够，中文是3个字节，每次读取一个字节
            }
        }catch (IOException e){
            System.out.println("输入异常！");
        }
    }
    public static void test3(){

        try(InputStreamReader reader = new InputStreamReader(
                new URL("http://www.baidu.com").openStream())){
            String str;
            int len = -1;
            while((len=reader.read())!=-1){
                System.out.print((char)len); //
            }
        }catch (IOException e){
            System.out.println("输入异常！");
        }
    }
}
