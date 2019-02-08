package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * FileUtils进行文件拷贝
 */
public class CIOTest05 {
    public static void main(String[] args) throws IOException {
        //复制文件到文件
//        FileUtils.copyFile(
//                new File("ciow.txt"),new File("src/CommonsIO/ciow-copy.txt"));
        //复制文件到目录
//        FileUtils.copyFileToDirectory(
//                new File("123.jpg"),new File("src/CommonsIO"));
        //复制指定目录中的文件到指定目录中
        //FileUtils.copyDirectory(new File("src/images"),new File("images-copy"));
        //复制目录到目录
//        FileUtils.copyDirectoryToDirectory(
//                new File("src/images"),new File("images2-copy")
//        );
        //拷贝url内容到文件
//        String url = "http://imgsrc.baidu.com/forum/pic/item/1ed8890e7bec54e7002fe020b5389b504ec26a30.jpg";
//        FileUtils.copyURLToFile(new URL(url),new File("巴御前.jpg"));
        String msg = IOUtils.toString(new URL("https://www.bilibili.com"),"utf-8");
        System.out.println(msg);
    }
}
