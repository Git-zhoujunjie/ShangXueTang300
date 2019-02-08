package JavaIO;

import java.io.*;

/**
 * 实现一个纯文本的拷贝功能，添加缓冲流
 *
 */
public class CopyTxt {

    public static void copyFile(String srcPath, String destPath){
        //选择源
        File src = new File(srcPath);
        File dest = new File(destPath);

        //选择流
//        InputStream in = null;
//        OutputStream out = null;

        /**
         * try...with...resources，实现自动释放流
         * 添加字符缓冲流
         * 字符缓冲流存在新方法，所以不能用多态（Reader r = new BuffBufferedReader()）
         */
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
//            in = new FileInputStream(src);
//            out = new FileOutputStream(dest);
//            byte[] bytes = new byte[1024];
//            int len = -1;
//            while((len = in.read(bytes))!=-1){  //读取操作
//
//                out.write(bytes,0,len);  //写入操作
//            }
//            out.flush();

            String line = null;
            while((line = br.readLine())!=null){  //新方法
                bw.write(line);
                bw.newLine(); //新方法
            }
            bw.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }/*finally { //结束流，记住：先打开的流要后关闭
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        */
    }

    public static void main(String[] args) {
        copyFile("11.txt","11copy.txt");
    }

}
