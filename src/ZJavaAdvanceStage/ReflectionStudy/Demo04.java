package ZJavaAdvanceStage.ReflectionStudy;

import ZJavaAdvanceStage.ReflectionStudy.bean.User;

import java.lang.reflect.Method;

/**
 * 测试反射的性能
 */
public class Demo04 {
    public static void test1(){
        User u = new User();
        long t1 = System.currentTimeMillis();
        for(int i=0;i<1000000000L;i++){
            u.setName("老何");
        }
        long t2 = System.currentTimeMillis();

        System.out.println("普通方法调用执行时间："+(t2-t1));
    }

    public static void test2() {
        String path = "ZJavaAdvanceStage.ReflectionStudy.bean.User";
        Class clazz = null;
        try {
            clazz = Class.forName(path);

            User u = (User) clazz.getDeclaredConstructor().newInstance(); //默认采用空构造器创建对象

            long t1 = System.currentTimeMillis();
            Method m = clazz.getDeclaredMethod("setName", String.class);
           // m.setAccessible(true);
            for (int i = 0; i < 1000000000L; i++) {
                m.invoke(u,"老何");
            }
            long t2 = System.currentTimeMillis();

            System.out.println("采用反射（未setAccessible）的执行时间：" + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3(){
        String path = "ZJavaAdvanceStage.ReflectionStudy.bean.User";
        Class clazz = null;
        try {
            clazz = Class.forName(path);

            User u = (User) clazz.getDeclaredConstructor().newInstance(); //默认采用空构造器创建对象

            long t1 = System.currentTimeMillis();
            Method m = clazz.getDeclaredMethod("setName", String.class);
            m.setAccessible(true);
            for (int i = 0; i < 1000000000L; i++) {
                m.invoke(u,"老何");
            }
            long t2 = System.currentTimeMillis();

            System.out.println("采用反射（setAccessible）的执行时间：" + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }
}
