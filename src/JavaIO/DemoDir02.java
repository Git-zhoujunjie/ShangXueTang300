package JavaIO;


import java.io.File;

public class DemoDir02 {

    public static void main(String[] args){
        String path = "D:/JavaTest/src/ShangXueTang300";
        File file = new File(path);
//        file.mkdir();
//        file.mkdirs();

        print(file,0);
//        String[] sublist = file.list();
//        for(String s:sublist){
//            System.out.println(s);
//        }
//        File[] subfile = file.listFiles();
//        for(File s:subfile){
//            System.out.println(s.getAbsolutePath());
//        }
    }

    public static void print(File file,int level){
        for(int i=0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file == null || !file.exists())
            return;
        else if(file.isDirectory()){
            for(File f:file.listFiles())
                print(f,level+1);
        }
    }
}
