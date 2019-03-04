package DesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类，这就相当于jdk中的容器类，所有的容器都实现了iterator
 */
public class ConcreteMyAggregate {
    private List<Object> list = new ArrayList<>();

    public void addObject(Object obj){
        this.list.add(obj);
    }

    public void removeObject(Object obj){
        this.list.remove(obj);
    }

    //定义为内部类，因为内部类可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator{
        private int cursor=0;
        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public Object next() {
            Object o = null;
            if(cursor<list.size()){
                o = list.get(cursor);
                cursor++;
            }
            return o;
        }

        @Override
        public boolean hasNext() {
            return cursor<list.size()?true:false;
        }

        @Override
        public boolean isFirst() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }

    //逆向迭代器
    private class ConcreteConverseIterator implements MyIterator{
        private int cursor=list.size()-1;
        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public Object next() {
            Object o = null;
            if(cursor>=0){
                o = list.get(cursor);
                cursor--;
            }
            return o;
        }

        @Override
        public boolean hasNext() {
            return cursor>=0?true:false;
        }

        @Override
        public boolean isFirst() {
            return cursor==0?true:false;
        }

        @Override
        public boolean isLast() {
            return cursor==list.size()-1?true:false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }


    //返回一个迭代器
    public MyIterator createIterator(){
        return new ConcreteIterator();
    }

    //返回一个逆向迭代器
    public MyIterator createConIterator(){
        return new ConcreteConverseIterator();
    }
}
