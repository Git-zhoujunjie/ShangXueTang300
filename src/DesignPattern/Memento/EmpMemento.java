package DesignPattern.Memento;

/**
 * 备忘录类
 * 对Emp类中的属性进行备份
 */
public class EmpMemento {
    private String name;
    private int age;
    private double salary;

    //构造器用于对传入的emp对象进行备份
    public EmpMemento(Emp emp){
        this.name = emp.getName();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
