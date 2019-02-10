package GaojiThem;

/**
 *单例模式：懒汉式基础上加入并发控制，保证在多线程环境下，对外只存在一个对象
 * 1、构造器私有化-->避免外部new构造器
 * 2、提供私有的静态属性-->存储对象地址
 * 3、提供公有的静态方法-->外部获取对象地址
 */
public class DoubleCheckedLocking {
    //2、提供私有的静态属性-->存储对象地址
    private static volatile DoubleCheckedLocking instance; //volatile防止指令重排，及时同步对象信息
    //没有volatile，其他线程肯能访问一个没有初始化的对象

    //1、构造器私有化-->避免外部new构造器
    private DoubleCheckedLocking(){}

    //3、提供公有的静态方法-->外部获取对象地址
    public static DoubleCheckedLocking getInstance(){
        //doublechecking，防止多余的等待和同步
        if(null != instance){
            return instance;
        }
        //加入并发控制
        synchronized (DoubleCheckedLocking.class) {  //DoubleCheckedLocking.class相当于一个类创建对象的模子，每次创建对象时都是共用这个模子
            if(null == instance) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }
        }
        /*指令重排的情况考虑：
        new一个对象分为三个步骤：1.分配对象空间；2.初始化类信息；3.返回对象地址
        这里步骤2可能较为耗时，导致jvm会进行指令重排，先执行步骤3，这样返回的对象可能为空
        因此，需要对instance进行volatile修饰，让instance的值能及时更新
         */
        return instance;
    }

    public static DoubleCheckedLocking getInstance1(){
        //doublechecking，防止多余的等待
        if(null != instance){
            return instance;
        }
        //加入并发控制
        //synchronized (DoubleCheckedLocking.class) {  //DoubleCheckedLocking.class相当于一个类创建对象的模子，每次创建对象时都是共用这个模子
            if(null == instance) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                instance = new DoubleCheckedLocking();
            }
        //}
        /*指令重排的情况考虑：
        new一个对象分为三个步骤：1.分配对象空间；2.初始化类信息；3.返回对象地址
        这里步骤2可能较为耗时，导致jvm会进行指令重排，先执行步骤3，这样返回的对象可能为空
        因此，需要对instance进行volatile修饰，让instance的值能及时更新
         */
        return instance;
    }
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            new Thread(() -> {
                System.out.println(DoubleCheckedLocking.getInstance()); //返回对象的地址
            }).start();
        }
    }

}
