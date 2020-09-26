package DesignPattern.Proxy.DynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MishuHandler implements InvocationHandler {

    private Laozong laozong;

    public MishuHandler(Laozong laozong) {
        this.laozong = laozong;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("秘书帮老总预时间");
        Object result = method.invoke(laozong,args);
        System.out.println("秘书帮老总处理后事");

        return result;
    }
}
