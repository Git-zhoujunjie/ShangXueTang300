package JavaIO;

import java.io.*;

/**
 * 测试 转换流
 * 1.InputStreamReader(extends Reader): 字节流转成字符流（即解码：输入字节流，然后可以进行转换成字符流）
 * 2.OutputStreamWriter(extends Writer): 字符流转成字节流（即编码：输入字符流，然后可以进行转换成字节流）
 */
public class DemoIO07 {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 测试 System.in 和 System.out
     * System.in：控制台输入，输入的为字节流，需要转换成字符流进行处理
     * System.out：控制台输出，输出为字符流，需要转换成字节流
     */

    public static void test1(){

        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            String str = null;
            while(!(str=reader.readLine()).equals("exit")){
               // System.out.println(str);
                writer.write(str);
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("输入异常！");
        }
    }
}
