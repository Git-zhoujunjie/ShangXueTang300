package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 使用FileUtils进行文件的读写
 */
public class CIOTest03 {
    public static void main(String[] args) throws IOException {
        String msg = FileUtils.readFileToString(
                new File("11copy.txt"),"UTF-8"); //直接读取文件
        System.out.println(msg);

        byte[] bytes = FileUtils.readFileToByteArray(new File("11copy.txt"));//读取字节数组
        System.out.println(bytes.length);

        List<String> lists = FileUtils.readLines(
                new File("11copy.txt"),"utf8"); //逐行读取
        for(String s : lists){
            System.out.println(s);
        }

        LineIterator lt = FileUtils.lineIterator(
                new File("11copy.txt"),"utf8"); //迭代器进行逐行读取
        while(lt.hasNext()){
            System.out.println(lt.nextLine());
        }
    }
}
