package BuildServer.ServerStudy01;

/**
 * 反射：把Java类中的各种结构（方法、属性、构造器、类名）映射成一个个Java对象
 * 1、获取Class对象
 * 三种方式：推荐方式3
 * 2、可以动态创建对象
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        //三种方式
        //1、对象.getClass()，从现有的对象中映射类的信息
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        //2、类.class()，若当前类存在，可以直接返回
        clz=Iphone.class;
        //3、Class.forName("包名.类名")
        clz = Class.forName("BuildServer.ServerStudy01.Iphone");


        //创建对象
        //jdk9之后不推荐使用
        //Iphone iphone1 = (Iphone)clz.newInstance();
        Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();

        System.out.println(iphone2);
    }
}

class Iphone{
    public Iphone(){}
}
