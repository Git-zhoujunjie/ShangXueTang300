package JavaIO;

import java.io.File;

public class testFile01 {

    public static void main(String[] args) {
        String path = "D:\\JavaTest\\src\\ShangXueTang300\\images\\123.jpg";
        String path2 = "D:"+File.separatorChar+
                "JavaTest"+File.separatorChar+
                "src"+File.separatorChar+
                "ShangXueTang300"+File.separatorChar+
                "images"+File.separatorChar+"123.jpg";
        System.out.println(path);
        System.out.println(path2);

    }

}
