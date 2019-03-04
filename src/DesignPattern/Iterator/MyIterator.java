package DesignPattern.Iterator;

/**
 * 自定义迭代器接口
 */
public interface MyIterator {
    void first(); //将游标指向第一个元素
    Object next();  //将当前元素返回，并将游标指向下一个元素

    boolean hasNext();  //判断是否存在下一个元素

    boolean isFirst();
    boolean isLast();

    Object getCurrentObj(); //将当前元素返回
}
