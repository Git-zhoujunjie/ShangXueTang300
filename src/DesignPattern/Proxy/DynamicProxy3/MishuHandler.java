package DesignPattern.Proxy.DynamicProxy3;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Cglib实现动态代理
 * 原理：实现要代理的方法的子类，并在子类中加上新功能
 */
public class MishuHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("秘书帮忙预约");

        Object result = methodProxy.invokeSuper(o,objects);

        System.out.println("秘书帮忙记录");
        return result;
    }
}
