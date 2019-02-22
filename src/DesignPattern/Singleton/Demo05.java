package DesignPattern.Singleton;

/**
 * 测试枚举式实现单例模式
 * 线程安全、调用效率高、不能延时加载，可以天然的防止反射和反序列化漏洞
 */
public enum Demo05 {
    INSTANCE;

    //添加你想要的方法
    public void fun(){}
}
