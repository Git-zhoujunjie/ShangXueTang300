package JavaIO;

import java.io.*;

/**
 * 测试数据流(是一种装饰流，用来装饰节点流)
 * 主要用于处理八大基本数据类型
 * DataInputStream : 能够读取数据和数据类型
 * DataOutputStream
 *
 * 1.先写出后读取
 * 2.读取顺序要和写出保持一致
 */
public class DemoIO09 {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        //需要先写出到DataOutputStream中，然后再用DataInputStream读取
        try(
            OutputStream os = new FileOutputStream("22.txt");
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));//os是节点流，可加缓冲流
            InputStream is = new FileInputStream("22.txt");
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));
        ){
            dos.write(100);
            dos.writeBoolean(false);
            dos.writeChar('b');
            dos.writeUTF("中国人");
            dos.flush();

            //读取顺序需要和写入顺序一致
            System.out.println(dis.read());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
            System.out.println(dis.readUTF());

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void test2(){
        //需要先写出到DataOutputStream中，然后再用DataInputStream读取
        byte[] bytes = null;
        try(
                OutputStream os = new FileOutputStream("22.txt");
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));
                BufferedInputStream fis =new BufferedInputStream( new FileInputStream("22.txt"));
        ){
            dos.writeInt(4354);
            dos.writeBoolean(true);
            dos.writeChar('g');
            dos.writeUTF("中国人safd");
            dos.flush();

            bytes = fis.readAllBytes();

            InputStream is = new ByteArrayInputStream(bytes);//字节数组流可以不用关闭
            DataInputStream dis = new DataInputStream(new BufferedInputStream(is));

            //读取顺序必须和写入顺序一致
            if(bytes!=null) {
                System.out.println(dis.readInt());
                System.out.println(dis.readBoolean());
                System.out.println(dis.readChar());
                System.out.println(dis.readUTF());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
