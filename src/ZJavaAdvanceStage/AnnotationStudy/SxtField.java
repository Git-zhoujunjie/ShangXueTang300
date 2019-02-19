package ZJavaAdvanceStage.AnnotationStudy;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 实现类中属性到表中字段的映射
 * 每一个类的属性相当于表的一个字段（就是一个列）,因此每一列都包括列名、数据类型和长度
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtField {
    String columnName();  //列名
    String type();   //数据类型
    int lenth();   //长度
}
