package DesignPattern.Singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 测试反射破解单例模式
 */
public class Demo06 implements Serializable {
    //懒汉式单例模式 在加载类时不会初始化对象
    private static Demo06 instance ;

    //构造器必须私有化，
    private Demo06(){
        //防止通过反射破解单例模式
        if(instance != null){
            throw new RuntimeException();
        }
    }

    //方法需要同步，只有在要用到的时候才需要创建对象，调用效率低
    public synchronized static Demo06 getInstance(){
        if(null == instance){
            instance = new Demo06();
        }

        return instance;
    }

    //反序列化时，如果定义了这个方法，则会直接返回该方法指定的对象，不会再创建新对象
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}
