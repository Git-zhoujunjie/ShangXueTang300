package ZJavaAdvanceStage.TestJavassist;

import javassist.*;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("Emp");

        //创建属性
        CtField f1 = CtField.make("private String name;",cc);
        CtField f2 = CtField.make("private int age;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public String getName(){return this.name;}",cc);
        CtMethod m2 = CtMethod.make("public void setName(String name){this.name = name;}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //创建构造器
        CtConstructor c1 = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        c1.setBody("{this.name=name;this.age = age;}");
        cc.addConstructor(c1);

        cc.writeFile("D:\\JavaProject\\ShangXueTang300");

    }
}
