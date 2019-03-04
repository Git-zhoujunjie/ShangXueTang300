package DesignPattern.Composite;


/**
 * 三个组件的关系
 */


/**
 * 抽象组件
 */
public interface Component {
    void Operate();
}

/**
 * 叶子节点
 */
interface Leaf extends Component{
}

/**
 * 容器组件，包含对节点的增删
 */
interface Composite extends Component{
    void add(Component c);
    void remove(Component c);
    Component get(int index);
}
