package JavaIO;

import java.io.*;

/**
 * 测试打印流
 * PrintStream
 */
public class DemoIO11 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out; //System.out是一个打印流
        ps.println("打印流");

        ps = new PrintStream(new BufferedOutputStream
                (new FileOutputStream("321.txt")),true); //即 将内容打印到指定文件中
        ps.println("编程辛酸泪");
        ps.println(12345);
        ps.println(true);

        //重定向输出端
        System.setOut(ps);
        System.out.println("重定向输出端");
        //重定向回控制台
        System.setOut(new PrintStream(new BufferedOutputStream
                (new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("重定向回控制台");

        PrintWriter pr = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream("printwriter.txt")),true);

        pr.println("printwriter！");
    }
}
