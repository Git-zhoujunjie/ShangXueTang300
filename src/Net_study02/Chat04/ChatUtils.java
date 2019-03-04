package Net_study02.Chat04;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 * 用于释放资源
 */
public class ChatUtils {
    //所有的IO都实现了Closeable接口
    public static void close(Closeable... stream) {
        for (Closeable s : stream) {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
