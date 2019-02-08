package JavaIO;

import java.io.*;

/**
 * 测试输出流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放
 */
public class DemoIO01 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "aa.txt";//相对路径，上级目录为工程目录
        //选择源
        File file = new File(path);
        InputStream is =null;
        try {
           //int temp = is.read();
            //创建流
           is = new BufferedInputStream(new FileInputStream(file));
//           int temp;
//           //操作 : 一个一个字节的读取
//           while((temp=is.read())>0){
//               System.out.println((char) temp);
//           }
            byte[] bytes = new byte[1024]; //一般都是1024个字节（也就是1k）进行读取
            int len = -1;
            while((len=is.read(bytes))!=-1){

                String str = new String(bytes,0,len); //字节流-->字符串 ：解码
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //释放系统资源
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
