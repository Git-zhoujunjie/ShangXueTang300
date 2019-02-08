package SynchronizedStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全
 * 测试多线程往容器中添加元素
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(0);
            }).start();
        }

        System.out.println(list.size());
    }
}
