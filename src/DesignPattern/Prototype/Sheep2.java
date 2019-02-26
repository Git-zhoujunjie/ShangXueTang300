package DesignPattern.Prototype;

import java.util.Date;

/**
 * 测试原型模式，即利用clone方法，必须实现Cloneable接口，注意clone方法不是Cloneable接口中的
 *
 * 实现深复制
 */
public class Sheep2 implements Cloneable{   //1997，英国多利克隆羊
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();//直接调用Object类的clone方法

        //实现深复制，即对属性也进行Clone
        Sheep2 s = (Sheep2) obj;
        s.birthday = (Date)this.birthday.clone();

        return obj;
    }

    public Sheep2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Sheep2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
