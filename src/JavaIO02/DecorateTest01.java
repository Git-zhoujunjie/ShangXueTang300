package JavaIO02;

/**
 * 体会装饰设计模式
 * 模拟咖啡
 * 1.抽象组件：需要装饰的抽象对象（接口或抽象父类）
 * 2.具体组件：需要装饰的对象
 * 3.抽象装饰类：包含对抽象组件的引用以及装饰的共有方法
 * 4.具体装饰类：被装饰的对象
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        System.out.println(coffee.cost()+"--->"+coffee.info());
        Drink milkcoffee = new MilkCoffee(coffee);
        System.out.println(milkcoffee.cost() + "--->" +milkcoffee.info());
        Drink sugarcoffee = new SugarCoffee(coffee);
        System.out.println(sugarcoffee.cost() + "--->" +sugarcoffee.info());

        Drink mixcoffee = new SugarCoffee(milkcoffee);
        System.out.println(mixcoffee.cost()+ "--->" +mixcoffee.info());

    }
}

//抽象组件
interface Drink{
    double cost();
    String info();
}

//具体组件
class Coffee implements Drink {
    private double cost = 10;
    private String info = "原味咖啡";

    @Override
    public double cost() {
        return cost;
    }

    @Override
    public String info() {
        return info;
    }
}

//抽象装饰类
abstract class Decorate implements Drink {
    private Drink drink;

    public Decorate(Drink Drink) {
        this.drink = Drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

//具体装饰类
class MilkCoffee extends Decorate{
    public MilkCoffee(Drink coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info() + "加入牛奶";
    }
}

//具体装饰类
class SugarCoffee extends Decorate{
    public SugarCoffee(Drink coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info() + "加入白糖";
    }
}


