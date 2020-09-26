package JVMStudy;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader()); //应用程序类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent()); //扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println("**********************");

        String a = "test";
        //双亲委托机制，不会加载自定义的String类
        //保证Java核心库的安全，保证不会出现用户自定义java.lang.object类的情况
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);
    }
}
