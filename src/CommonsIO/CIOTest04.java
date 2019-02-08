package CommonsIO;

import JavaIO.FileUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileUtils进行文件写出
 */
public class CIOTest04 {
    public static void main(String[] args) throws IOException {
        String path = "ciow.txt";
        FileUtils.write(new File(path),"锄禾日当午\r\n","utf-8");

        FileUtils.writeByteArrayToFile(new File(path),
                "编码真辛苦\r\n".getBytes("utf-8"),true);

        FileUtils.writeStringToFile(new File(path),"一行小代码\r\n","utf-8",true);

        List<String> strings = new ArrayList<>();
        strings.add("一写一下午");
        strings.add("end");

        FileUtils.writeLines(new File(path),strings,"-----",true);
    }
}
