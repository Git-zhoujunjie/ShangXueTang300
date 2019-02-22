package DesignPattern.Singleton;

/**
 * 双重检查锁单例模式
 * 不推荐使用
 */
public class Demo03 {

    private static Demo03 instance ;

    //构造器必须私有化
    private Demo03(){}

    public static Demo03 getInstance(){
        if(null == instance){
            Demo03 d ;
            synchronized (Demo03.class){
                d = instance;
                if(d == null){
                    synchronized (Demo03.class) {
                        if(d == null){
                            d = new Demo03();
                        }
                    }
                    instance = d;
                }

            }
        }

        return instance;
    }
}
