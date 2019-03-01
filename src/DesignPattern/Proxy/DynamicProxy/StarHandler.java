package DesignPattern.Proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler {
    private Star star;

    public StarHandler(Star star) {
        this.star = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("******");
        Object o = null;

        System.out.println("真正的方法执行前");
        System.out.println("协商、签合同，订票");
        //核心业务 唱歌
        if(method.getName().equals("sing")) {
            o = method.invoke(star, args);
        }
        System.out.println("真正的方法执行后");
        System.out.println("收钱");
        return o;
    }
}
