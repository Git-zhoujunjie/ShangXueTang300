package DesignPattern.Bridge;

/**
 * 类型
 */
public abstract class Computer {
    //一台电脑自带品牌属性
    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void sale(){
        brand.sale();
    }
}

class Desktop extends Computer{
    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售联想电脑");
    }
}

class Laptop extends Computer{
    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();

        System.out.println("销售笔记本");
    }
}

class Pad extends Computer{
    public Pad(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();

        System.out.println("销售平板");
    }
}

class Mobile extends Computer{
    public Mobile(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();

        System.out.println("销售移动手机");
    }
}