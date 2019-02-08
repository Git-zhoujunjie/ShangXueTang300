package CommonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * 用CommonsIO计算文件长度
 */
public class CIOTest01 {
    public static void main(String[] args) {
        long len = FileUtils.sizeOf(new File("123.jpg"));

        long len2 = FileUtils.sizeOfDirectory(new File("src/images"));
        System.out.println(len);
        System.out.println(len2);
    }
}
