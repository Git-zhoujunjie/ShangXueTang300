package Net_study02;

import java.io.Serializable;

//JavaBean
class Employee implements Serializable{ //若要对这个类进行序列化，要实现Serializable接口

    private transient String name; //transient 表示该数据不可序列化
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}