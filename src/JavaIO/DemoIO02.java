package JavaIO;

import java.io.*;

public class DemoIO02 {
    public static void main(String[] args){
        String path = "aa.txt";
        File file = new File(path);

        Reader reader = null;

        try {
            reader = new FileReader(file);
            int temp ;
            while ((temp = reader.read()) != -1){
                System.out.println((char)temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader !=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
