package ThreadStudy;

/**
 * //利用Thread类实现多线程
 *
 */
//public class ThreadDemo01 extends Thread{

/**
 * 实现Runnable接口
 */
public class ThreadDemo01 implements Runnable{
    @Override
    public void run() { //线程体，即实现的内容
        for(int i=0;i<100;i++){
            System.out.println("一边coding");
        }
    }

//    public static void main(String[] args) {
//        ThreadDemo01 test = new ThreadDemo01();
//
//        //test.start();//表示告诉调度器，让操作系统来调用run()方法，不一定立即执行
//
//        //test.run();//此为普通的方法调用，不会产生多线程
//
//        for(int i=0;i<30;i++){
//            System.out.println("一边看直播");
//        }
//    }

    public static void main(String[] args) {

        //匿名内部类，当声明的对象只用一次时，无需声明出对象的名称，直接写匿名
        new Thread(new ThreadDemo01()).start();



        for(int i=0;i<100;i++){
            System.out.println("一边看直播");
        }
    }
}
