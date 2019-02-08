package SynchronizedStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized块
 */
public class SynBlockTest02 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        for(int i=0;i<1000;i++){
            new Thread(()->{
                synchronized (list) { //同步块
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        //由于打印操作和添加数据操作是两个线程（main和其他线程）同时进行，因此需要加一段延时后读取数据才正确
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
