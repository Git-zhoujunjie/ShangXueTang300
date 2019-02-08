package ThreadStudy;

/**
 * 认识Lambda表达式，简化简单线程（用一次）的使用
 *
 * 对Lambda表达式进行推导
 * 外部类或接口->静态内部类->局部内部类->匿名内部类->Lambda表达式
 *
 *
 */
public class LambdaDemo01 /*implements Runnable    1.外部类或接口*/{

//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            System.out.println("一边coding");
//        }
//    }

    //2. 静态内部类
    static class lambda02 implements Runnable {
        @Override
        public void run() { //线程体，即实现的内容
            for (int i = 0; i < 5; i++) {
                System.out.println("一边coding2");
            }
        }
    }

    public static void main(String[] args) {
        //匿名对象，当声明的对象只用一次时，无需声明出对象的名称，直接写匿名
        // new Thread(new ThreadDemo01()).start();  1.外部类或接口

        new Thread(new lambda02()).start(); //2. 静态内部类

        //局部内部类
        class lambda03 implements Runnable {
            @Override
            public void run() { //线程体，即实现的内容
                for (int i = 0; i < 5; i++) {
                    System.out.println("一边coding3");
                }
            }
        }
        new Thread(new lambda03()).start(); //2. 局部内部类


        //3. 匿名内部类
        new Thread(new Runnable() { //必须借助接口或父类，这里是Runnable()，然后重写重载的方法
            @Override
            public void run() { //线程体，即实现的内容
                for (int i = 0; i < 5; i++) {
                    System.out.println("一边coding4");
                }
            }
        }).start();

        //4. Lambda表达式（jdk8以上版本特有） , 函数式编程的思想
        new Thread(() -> { //省略掉接口名(或父类名)和函数名，jdk会自动推导出方法体是重写了Runnable接口中的run()方法
            for (int i = 0; i < 5; i++) {
                System.out.println("一边coding5");
            }
        }).start();


    }
}
