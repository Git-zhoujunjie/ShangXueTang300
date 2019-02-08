package JavaIO;


import java.io.*;

/**
 * 手写一个文件拷贝函数
 * 即整合 InputStream和OutputStream 即可
 *
 * 新增try...with...resources，实现自动释放流
 */
public class CopyFile {
    /**
     *
     * 源文件 src
     * 目的文件 dest
     */
    public static void copyFile(String srcPath, String destPath){
        //选择源
        File src = new File(srcPath);
        File dest = new File(destPath);

        //选择流
//        InputStream in = null;
//        OutputStream out = null;

        try(InputStream in = new BufferedInputStream(new FileInputStream(src));  //try...with...resources，实现自动释放流
            OutputStream out = new BufferedOutputStream(new FileOutputStream(dest))) {
//            in = new FileInputStream(src);
//            out = new FileOutputStream(dest);
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

    public static void main(String[] args){
        //copyFile("bb.txt","cc.txt");

        copyFile("123.jpg","321.jpg");

    }
}
