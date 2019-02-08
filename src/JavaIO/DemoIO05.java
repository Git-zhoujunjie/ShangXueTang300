package JavaIO;

import java.io.*;

public class DemoIO05 {
    public static void main(String[] args){
        String path = "22.txt";
        File file = new File(path);

        Writer writer = null;

        try {
            writer = new FileWriter(file);
            //方法一
            String sr = "十年后的你会感谢今天努力的你！";
//            char[] chars = sr.toCharArray();
//            writer.write(chars);
            //方法二
            writer.write(sr);
            //方法三
            writer.append(sr).append("\n123").append("\nasdfa");
            writer.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //释放系统资源
                if(writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
