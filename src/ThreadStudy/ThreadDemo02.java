package ThreadStudy;

/**
 * 启动线程方式一：
 * 1、创建：继承Thread类+重写run
 * 2、启动：创建子类对象 + start
 */
public class ThreadDemo02 extends Thread{

    private String url;
    private String dest;

    public ThreadDemo02(String url, String dest) {
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

        ThreadDemo02 test4 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/f454598b4710b912cabb9b10c8fdfc03934522ae.jpg","Fate/黑贞2.jpg");
        ThreadDemo02 test5 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/90321212b31bb051bcd4dec63d7adab44bede035.jpg","Fate/黑贞3.jpg");
        ThreadDemo02 test6 = new ThreadDemo02("http://imgsrc.baidu.com/forum/pic/item/814b50ec54e736d194efe1e690504fc2d4626921.jpg","Fate/贞德&学妹.jpg");

        //三条线程同时进行
        test4.start();
        test5.start();
        test6.start();
    }
}
