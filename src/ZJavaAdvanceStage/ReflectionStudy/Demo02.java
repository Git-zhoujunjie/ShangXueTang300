package ZJavaAdvanceStage.ReflectionStudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "ZJavaAdvanceStage.ReflectionStudy.bean.User";

        try {
            Class clazz = Class.forName(path);
            System.out.println(clazz.getName());
            System.out.println(clazz.getSimpleName()); //类名

            //属性
           // Field[] fields = clazz.getFields(); //只能获得public属性
            Field[] fields = clazz.getDeclaredFields();  //获得所有的属性
            Field f = clazz.getDeclaredField("name");
            System.out.println(fields.length);
            for(Field field:fields){
                System.out.println("属性："+field);
            }

            //方法
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getName",null);
            //如果方法有参数，则必须传递参数类型对应的class对象，由于方法可能会重载，因此需要设置参数的类型
            Method m02 = clazz.getDeclaredMethod("setName", String.class);
            for(Method m :methods){
                System.out.println("方法："+m);
            }
            //获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for(Constructor c:constructors){
                System.out.println("构造器："+c);
            }
            Constructor c1 = clazz.getDeclaredConstructor(null); //获取空构造器
            //获取带参构造器
            Constructor c2 = clazz.getDeclaredConstructor(String.class,int.class,double.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
