package ZJavaAdvanceStage.DynamicCompileStudy;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * 测试动态编译的两种方式
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        //方式1：
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,
                "D:\\JavaProject\\ShangXueTang300\\DynamicCompile1.java");

        System.out.println(result+(result==0?"编译成功":"编译失败"));

        //方式二：
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp  D:\\JavaProject\\ShangXueTang300  DynamicCompile2");
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
        String info = "";
        while((info=br.readLine())!=null){
            System.out.println(info);
        }

        //方式三：用方式一，现将字符串存储为文件，再进行读取编译
        String str = "public class DynamicCompile2{\n" +
                "    public static void main(String[] args){\n" +
                "        System.out.println(\"Hello DynamicCompile！\");\n" +
                "    }\n" +
                "}";
        String fileName = str.substring(str.indexOf("class")+6,str.indexOf("{")) + ".java";
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(new File(fileName))));

        bw.write(str);
        bw.flush();

        bw.close();

        JavaCompiler compiler2 = ToolProvider.getSystemJavaCompiler();
        int result2 = compiler2.run(null,null,null,
                fileName);

        System.out.println(result2+(result2==0?"编译成功2":"编译失败2"));

    }
}
