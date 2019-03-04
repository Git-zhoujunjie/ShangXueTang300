package DesignPattern.FlyWeight;

/**
 * 测试享元模式
 */
public class Client {
    public static void main(String[] args) {
        //获得一颗黑色棋子
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getFlyWeight("black");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getFlyWeight("black");
        //可以看出两个棋子是同一个对象
        System.out.println(chess1);
        System.out.println(chess2);

        //这里可以看出，每个棋子的外部属性都要new一个对象，因此时间效率较低
        chess1.display(new Coordinate(10,10));
        chess2.display(new Coordinate(20,20));

        ChessFlyWeight chess3 = ChessFlyWeightFactory.getFlyWeight("white");
        chess3.display(new Coordinate(15,15));
    }
}
