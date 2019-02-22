package DesignPattern.Singleton;

/**
 * 测试懒汉式单例模式
 */
public class Demo02 {
    //懒汉式单例模式 在加载类时不会初始化对象
    private static Demo02 instance ;

    //构造器必须私有化，
    private Demo02(){
        //防止通过反射破解单例模式
//        if(instance != null){
//            throw new RuntimeException();
//        }
    }

    //方法需要同步，只有在要用到的时候才需要创建对象，调用效率低
    public synchronized static Demo02 getInstance(){
        if(null == instance){
            instance = new Demo02();
        }

        return instance;
    }
}
