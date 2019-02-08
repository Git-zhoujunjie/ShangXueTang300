package JavaIO;

import java.io.*;

/**
 * 实现 文件写入字节流，字节流写出到文件
 * 1、FileInputStream , ByteArrayOutputStream
 * 2、ByteArrayInputStream , FileOutputStream
 */
public class DemoIO06 {

    public static void main(String[] args){
        byte[] test1 = fileToByteArray("123.jpg");
        System.out.println(test1.length);

        byteArrayToFile(test1,"234.jpg");
    }
    /**
     * 文件写入到字节流
     */
    public static byte[] fileToByteArray(String filePath){
        File file = new File(filePath);
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
//            in = new FileInputStream(file);
//            out = new ByteArrayOutputStream();
            in = new BufferedInputStream(new FileInputStream(file)); //增加缓冲区，性能提升
            out = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int len =-1;
            while((len = in.read(bytes))!=-1){
                out.write(bytes,0,len);  //写入到字节流中
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return out.toByteArray();
    }
    /**
     * 字节流写出到文件
     */
    public static void byteArrayToFile(byte[] bytes,String filePath){
        File file = new File(filePath);
        OutputStream out = null;
        ByteArrayInputStream in = null;
        try {
            in = new ByteArrayInputStream(bytes);
            out = new BufferedOutputStream(new FileOutputStream(file));
           // byte[] temp = in.readAllBytes();

            byte[] temp = new byte[3];
            int len = -1;
            while((len = in.read(temp))!=-1) {
                out.write(temp, 0, temp.length);
            }

            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

