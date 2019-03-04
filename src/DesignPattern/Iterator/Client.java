package DesignPattern.Iterator;

/**
 * 测试迭代器
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aaa");
        cma.addObject("87654");
        cma.addObject("hfgdhg");
        cma.addObject("ddddd");

        MyIterator iterator = cma.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        MyIterator iterator1 = cma.createConIterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
