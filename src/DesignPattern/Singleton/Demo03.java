package DesignPattern.Singleton;

/**
 * 双重检查锁单例模式
 * 不推荐使用
 */
public class Demo03 {

    //volatile防止指令重排
    private volatile static Demo03 instance ;

    //构造器必须私有化
    private Demo03(){}

    public static Demo03 getInstance() {
        if (null == instance) {
            synchronized (Demo03.class) {
                if (instance == null) {
                    instance = new Demo03();
                }
            }
        }
        return instance;
    }
}
