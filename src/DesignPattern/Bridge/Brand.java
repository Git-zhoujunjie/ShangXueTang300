package DesignPattern.Bridge;

/**
 * 品牌
 */
public interface Brand {
    void sale();
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}

class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Shenzhou implements Brand{
    @Override
    public void sale() {
        System.out.println("销售神舟电脑");
    }
}