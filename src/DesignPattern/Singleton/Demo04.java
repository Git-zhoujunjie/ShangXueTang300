package DesignPattern.Singleton;

/**
 * 测试静态内部类实现单例模式
 * 线程安全，调用效率高，并且实现延时加载
 */
public class Demo04 {
    //构造器必须私有化
    private Demo04 (){}

    private static class SingletonInstance{
        private static final Demo04 instance = new Demo04();
    }
    public synchronized static Demo04 getInstance(){
        return SingletonInstance.instance;

    }
}
