package ZJavaAdvanceStage.AnnotationStudy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 解析SxtStudent类中的注解
 *
 * 使用反射读取注解信息，模拟处理注解信息的流程
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clz = Class.forName("ZJavaAdvanceStage.AnnotationStudy.SxtStudent");
            //获得类所有的注解(只有类的注解)
            Annotation[] annotations = clz.getAnnotations();
            for(Annotation a:annotations){
                System.out.println(a);
            }

            //获得SxtTable类中的直接
            SxtTable st = (SxtTable) clz.getAnnotation(SxtTable.class);
            System.out.println(st.value());

            //获得类属性的注解
            Field field = clz.getDeclaredField("studentName");
            SxtField sxtField = field.getAnnotation(SxtField.class);
            System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.lenth());

            //根据获得的表名、字段信息拼接成DDL语句，然使用JBDC执行SQL语句，生产相应的表

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
