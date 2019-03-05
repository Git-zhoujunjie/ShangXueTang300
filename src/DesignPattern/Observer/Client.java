package DesignPattern.Observer;

public class Client {
    public static void main(String[] args) {
        //目标对象
        Subject sj = new ConcreteSubject();

        //创建多个观察者
        Observers ob1 = new ObserverA();
        Observers ob2 = new ObserverA();
        Observers ob3 = new ObserverA();

        //将观察者添加到观察者队伍中
        sj.Register(ob1);
        sj.Register(ob2);
        sj.Register(ob3);

        ((ConcreteSubject) sj).setState(4000);
        System.out.println(((ObserverA) ob1).getMyState());
        System.out.println(((ObserverA) ob2).getMyState());
        System.out.println(((ObserverA) ob3).getMyState());
    }
}
