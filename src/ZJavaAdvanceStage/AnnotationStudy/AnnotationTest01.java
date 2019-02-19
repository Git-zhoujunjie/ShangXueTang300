package ZJavaAdvanceStage.AnnotationStudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Target表示指定当前注解的适用范围，
 * method表示该注解只能用于方法前面
 *
 * 用大括号括起来可实现多个方式的注解，TYPE表示可对类进行注解
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})
public @interface AnnotationTest01 {
}
