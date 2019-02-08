package JavaIO;

import java.io.*;

/**
 * 手写一个文件夹拷贝
 * 1.判断当前File是否为文件，若是文件，则直接拷贝；若是文件夹，则进行递归遍历
 * 2.mkdirs新建文件夹
 */
public class CopyDir {

    public static void main(String[] args){
        long begin = System.currentTimeMillis();
        copyFile("D:\\JavaTest\\src\\ShangXueTang300\\images","D:");
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

    public static void copyFile(String srcPath, String destPath){
        //选择源
        File src = new File(srcPath);
       // File dest = new File(destPath);


        if(src ==null || !src.exists()) return;
        else if(src.isDirectory()){
            //如果是文件夹，先在目的路径下创建一个相同的文件夹
            destPath = destPath+File.separatorChar+src.getName();
            File dest = new File(destPath);
            dest.mkdirs();

            for(File f : src.listFiles()){ //对文件夹中的文件进行递归遍历
                copyFile(f.getAbsolutePath(),destPath);
            }

        }else {
            //如果是文件，则在目的路径下创建一个同名的文件，然后进行读写操作
            String destFile = destPath +File.separatorChar+ src.getName();
            File dest = new File(destFile);
            //选择流
            InputStream in = null;
            OutputStream out = null;

            try {
                // 节点流
//                in = new FileInputStream(src);
//                out = new FileOutputStream(dest);
                // 装饰流
                in = new BufferedInputStream(new FileInputStream(src)); //增加缓冲区，性能提升
                out = new BufferedOutputStream(new FileOutputStream(dest));
                byte[] bytes = new byte[1024];
                int len = -1;
                while ((len = in.read(bytes)) != -1) {  //读取操作

                    out.write(bytes, 0, len);  //写入操作
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally { //结束流，记住：先打开的流要后关闭
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
