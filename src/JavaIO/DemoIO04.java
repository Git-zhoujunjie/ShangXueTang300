package JavaIO;

import java.io.*;

/**
 * 测试字符输入输出流
 * 1.FileReader
 * 2.FileWriter
 */
public class DemoIO04 {
    public static void main(String[] args){
        String path = "11.txt";
        File file = new File(path);

        Reader reader = null;

        try {
            reader = new FileReader(file);
            char[] flush = new char[1024];
            int len = -1;
            while((len = reader.read(flush))!=-1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //释放系统资源
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
