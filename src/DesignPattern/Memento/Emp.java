package DesignPattern.Memento;

public class Emp {
    private String name;
    private int age;
    private double salary;

    //将当前的属性生成一个备忘录对象返回
    public EmpMemento getMemento(){
        return new EmpMemento(this);
    }

    //恢复到备忘前状态
    public void recovery(EmpMemento eem){
        this.name = eem.getName();
        this.age = eem.getAge();
        this.salary = eem.getSalary();
    }

    public Emp(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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
