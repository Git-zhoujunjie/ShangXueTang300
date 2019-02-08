package JavaIO;

import java.io.*;

/**
 * 测试输出流 OutputStream
 * 1.创建源
 *  * 2.选择流
 *  * 3.操作(写出)
 *  * 4.释放
 */
public class DemoIO03 {
    public static void main(String[] args){
        String fileName = "bb.txt";
        File file = new File(fileName);

        OutputStream out = null;
        try {
            out = new BufferedOutputStream(new FileOutputStream(file,true));
            String txt = "I am going to study every day!\n";
            byte[] bytes = txt.getBytes(); //字符串-->字节流：编码
            out.write(bytes);
            out.flush(); //刷新


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
