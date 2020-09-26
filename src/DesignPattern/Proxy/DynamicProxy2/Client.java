package DesignPattern.Proxy.DynamicProxy2;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        MishuHandler mishu = new MishuHandler(new Laozong());

        Gongneng gn = (Gongneng) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Gongneng.class},mishu);
        gn.chifan();
        gn.tanshi();
    }
}
