package DesignPattern.FlyWeight;

/**
 * 抽象享元类，即要被共享的对象
 */
public interface ChessFlyWeight {
    void setColor(String color);  //设置棋子的颜色 ，内部属性可以共享
    void display(Coordinate c);  //显示棋子的位置 ，外部属性不能共享
}

/**
 * 具体享元类
 */
class ConcreteChess implements ChessFlyWeight{
    private String color;

    //存储内部状态，即共享的属性
    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子颜色为："+color);
        System.out.println("棋子坐标为："+c.getX()+"---"+c.getY());
    }
}
