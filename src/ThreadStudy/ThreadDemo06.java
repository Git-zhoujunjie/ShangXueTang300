package ThreadStudy;

import java.util.concurrent.*;

/**
 * 了解启动线程方式三：
 * 1、创建：实现Callable接口+重写call方法
 * 2、启动：创建实现类对象 + 创建执行服务 + 提交执行 + 获取结果 + 关闭服务
 *
 * 推荐使用RUnnable接口，避免Java单继承的局限性
 * 还能方便共享资源
 */
public class ThreadDemo06 implements Callable<Boolean> {

    private String url;
    private String dest;

    public ThreadDemo06(String url, String dest) {
        this.url = url;
        this.dest = dest;
    }

    @Override
    public Boolean call() throws Exception{ //call方法能够返回异常和返回值，，run()方法只能是void
        copyURLToFile cf = new copyURLToFile();
        cf.copy(url,dest);
        System.out.println(dest);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ThreadDemo02 test1 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/cf46588da9773912f158e88ff3198618377ae2a3.jpg","Fate/黑贞.jpg");
//        ThreadDemo02 test2 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/428e2146f21fbe09144eaefa60600c338644ad95.jpg","Fate/泳装.jpg");
//        ThreadDemo02 test3 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/7be2f233c895d143886589cd78f082025baf0795.jpg","Fate/bba.jpg");

        ThreadDemo06 test4 = new ThreadDemo06("http://imgsrc.baidu.com/forum/pic/item/6e693adfa9ec8a1300613b0efc03918fa1ecc0ae.jpg","Fate/bba2.jpg");
        ThreadDemo06 test5 = new ThreadDemo06("http://imgsrc.baidu.com/forum/pic/item/0dde283b5bb5c9ea85826f0dde39b6003bf3b3b4.jpg","Fate/黑贞5.jpg");
        ThreadDemo06 test6 = new ThreadDemo06("http://imgsrc.baidu.com/forum/pic/item/efcdff3f8794a4c277538bc505f41bd5ac6e39b4.jpg","Fate/花嫁.jpg");

        //三条线程同时进行
//        new Thread(test4).start();
//        new Thread(test5).start();
//        new Thread(test6).start();

        ExecutorService ser = Executors.newFixedThreadPool(3);//创建服务线程池
        //递交服务
        Future<Boolean> fu1 = ser.submit(test4);
        Future<Boolean> fu2 = ser.submit(test5);
        Future<Boolean> fu3 = ser.submit(test6);
        //获取结果
        boolean b1 = fu1.get();
        boolean b2 = fu2.get();
        boolean b3 = fu3.get();
        System.out.println(b1+"  "+b2 +"  "+b3);
        //关闭服务
        ser.shutdownNow();


    }
}
