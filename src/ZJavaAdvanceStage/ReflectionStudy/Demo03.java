package ZJavaAdvanceStage.ReflectionStudy;

import ZJavaAdvanceStage.ReflectionStudy.bean.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API操作类的构造器、属性和方法
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "ZJavaAdvanceStage.ReflectionStudy.bean.User";

        try {
            Class clazz = Class.forName(path);
            //通过反射创建对象
            User u1 = (User)clazz.newInstance();  //默认采用空构造器创建对象，但不推荐使用

            User u2 = (User)clazz.getDeclaredConstructor().newInstance(); //默认采用空构造器创建对象
            User u3 = (User)clazz.getDeclaredConstructor(String.class,int.class,double.class)
                    .newInstance("老周",25,2000); //采用带参构造器创建对象，可传入参数
            System.out.println(u3.getName()+"--"+u3.getAge()+"--"+u3.getSalary());

            //通过反射调用普通方法
            //1、首先获取要调用的方法，这里获取setName方法
            Method method = clazz.getDeclaredMethod("setName", String.class);
            //2、然后调用invoke方法，说明是u3对象调用setName方法设置为“老何”
            method.invoke(u3,"老何");
            System.out.println(u3.getName());   //以上两步等同于实现u3.setName("老何")
            //使用反射调用getName()方法
            System.out.println(clazz.getDeclaredMethod("getName").invoke(u3,null));

            //通过反射操作属性
            //1、首先获取要操作的属性
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true); //设置当前属性可操作，禁用访问安全检查的开关
            field.set(u3,"老肖"); //相当于u3.setName("老肖"),但是直接操作会提示属性私有无法操作
            System.out.println(u3.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
