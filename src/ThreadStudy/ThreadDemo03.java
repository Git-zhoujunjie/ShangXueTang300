package ThreadStudy;

/**
 * 启动线程方式二：
 * 1、创建：实现Runnable接口+重写run
 * 2、启动：创建实现类对象 + Thread对象（代理） + start
 *
 * 推荐使用RUnnable接口，避免Java单继承的局限性
 * 还能方便共享资源
 */
public class ThreadDemo03 implements Runnable{

    private String url;
    private String dest;

    public ThreadDemo03(String url, String dest) {
        this.url = url;
        this.dest = dest;
    }

    @Override
    public void run() { //线程体
        copyURLToFile cf = new copyURLToFile();
        cf.copy(url,dest);
        System.out.println(dest);
    }

    public static void main(String[] args) {

//        ThreadDemo02 test1 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/cf46588da9773912f158e88ff3198618377ae2a3.jpg","Fate/黑贞.jpg");
//        ThreadDemo02 test2 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/428e2146f21fbe09144eaefa60600c338644ad95.jpg","Fate/泳装.jpg");
//        ThreadDemo02 test3 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/7be2f233c895d143886589cd78f082025baf0795.jpg","Fate/bba.jpg");

        ThreadDemo03 test4 = new ThreadDemo03("http://imgsrc.baidu.com/forum/pic/item/be930c7f9e2f07087afa47eee224b899a801f222.jpg","Fate/女儿.jpg");
        ThreadDemo03 test5 = new ThreadDemo03("http://imgsrc.baidu.com/forum/pic/item/ed421efae6cd7b898092576d042442a7d8330e22.jpg","Fate/黑贞4.jpg");
        ThreadDemo03 test6 = new ThreadDemo03("http://imgsrc.baidu.com/forum/pic/item/63ea8f0f4bfbfbed87385a9173f0f736aec31fbb.jpg","Fate/武藏.jpg");

        //三条线程同时进行
        new Thread(test4).start();
        new Thread(test5).start();
        new Thread(test6).start();


    }
}
