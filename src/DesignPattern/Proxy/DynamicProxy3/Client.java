package DesignPattern.Proxy.DynamicProxy3;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Laozong.class);  //生成对象是Laozong类的子类
        enhancer.setCallback(new MishuHandler());  //指明代理处理者

        Laozong laozong = (Laozong) enhancer.create();  //创建子类
        laozong.chifan();  //调用
    }
}
