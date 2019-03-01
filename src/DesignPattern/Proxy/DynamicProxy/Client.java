package DesignPattern.Proxy.DynamicProxy;

import java.lang.reflect.Proxy;

/**
 *
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();
        StarHandler starHandler = new StarHandler(star);
        //创建一个代理对象
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class},starHandler);

        //会直接进入到StarHandle中的invoke方法中
        proxy.sing();
    }
}
