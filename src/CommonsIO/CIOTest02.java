package CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

/**
 * 用CommonsIO 实现文件的列表
 * 过滤器FileFilter的使用
 */
public class CIOTest02 {
    public static void main(String[] args) {
        Collection<File> files =
                FileUtils.listFiles(  //
                        new File("src"), EmptyFileFilter.NOT_EMPTY,null);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("-------------");
        files =
                FileUtils.listFiles(  //列出子孙级文件
                        new File("src"), EmptyFileFilter.NOT_EMPTY,
                        DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("-------------");
        files =
                FileUtils.listFiles(  //列出指定类型的文件（例 jpg）
                        new File("src"), new SuffixFileFilter("jpg"),
                        DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("-------------");
        files =
                FileUtils.listFiles(  //列出多种指定类型的文件（例 jpg和docx）
                        new File("src"),
                        FileFilterUtils.or(new SuffixFileFilter("jpg"),new SuffixFileFilter("docx")),
                        DirectoryFileFilter.INSTANCE);
        for(File file:files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
