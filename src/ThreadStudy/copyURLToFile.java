package ThreadStudy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class copyURLToFile {
    public void copy(String url,String dest){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
