package JavaIO;

import java.io.*;

/**
 * 实现一个文件流读写工具类，对之前的操作进行封装
 */
public class FileUtil {

    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("11.txt");
            OutputStream out = new FileOutputStream("11copy.txt");
            copyFile(in,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            InputStream in = new FileInputStream("123.jpg");
            OutputStream out = new ByteArrayOutputStream();
            copyFile(in,out);
            System.out.println(((ByteArrayOutputStream) out).toByteArray().length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    /**
     * 从in流中读取数据到out流中
     * @param in
     * @param out
     */
    public static void copyFile(InputStream in, OutputStream out){

        in = new BufferedInputStream(in); //增加缓冲区，性能提升
        out = new BufferedOutputStream(out);
        try {
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len = in.read(bytes))!=-1){  //读取操作

                out.write(bytes,0,len);  //写入操作
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally { //结束流，记住：先打开的流要后关闭
            close(in,out);
        }
    }

    /**
     * 封装 结束流 方法
     */
    public static void close(Closeable... ios){  //可变参数形式，可传入不定项参数
        for(Closeable io : ios){
            if(null!=io){
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
