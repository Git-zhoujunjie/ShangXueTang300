package DesignPattern.Singleton;

/**
 * 测试饿汉式单例模式
 */
public class Demo01 {
    //饿汉式单例模式 在jvm加载类的同时就新建了一个对象，天然是线程安全的
    private static Demo01 instance = new Demo01();

    //构造器必须私有化
    private Demo01(){}

    //方法不需要同步，效率高
    public static Demo01 getInstance(){
        return instance;
    }
}
