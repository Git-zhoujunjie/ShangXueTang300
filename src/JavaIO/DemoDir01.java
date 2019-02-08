package JavaIO;

import java.io.File;

public class DemoDir01 {

    public static void main(String[] args){
        String path = "D:/JavaTest/src/ShangXueTang300";
        File file = new File(path);
//        file.mkdir();
//        file.mkdirs();

        String[] sublist = file.list();
        for(String s:sublist){
            System.out.println(s);
        }
        File[] subfile = file.listFiles();
        for(File s:subfile){
            System.out.println(s.getAbsolutePath());
        }
    }
}
