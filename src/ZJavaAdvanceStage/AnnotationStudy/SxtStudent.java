package ZJavaAdvanceStage.AnnotationStudy;

/**
 * 根据一个类和相应的注解，
 * 实现ORM（Object Relationship Mapping）
 * 即从一个类对象到数据库表的映射
 */

@SxtTable("tb_student")  //表示这个类对应tb_student这个表
public class SxtStudent {
    @SxtField(columnName = "id",type = "int",lenth = 10)   //表中的ID列
    private int id;
    @SxtField(columnName = "sname",type = "varchar",lenth = 10) //表中的数据类型列
    private String studentName;
    @SxtField(columnName = "age",type = "int",lenth = 3)  //表中的长度列
    private int age;

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
