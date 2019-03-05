package DesignPattern.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 负责人类
 * 用于管理备忘录对象
 */
public class CareTaker {
    //这里用一个属性只保存一次备忘对象
    private EmpMemento empMemento;

    //用容器可以保存多次备忘点
    private List<EmpMemento> list = new ArrayList<>();

    //用栈保存更为合理
    private Stack<EmpMemento> stack = new Stack<>();

    //取出一个栈顶元素并删除
    public EmpMemento getEmpMemento() {
        if(!stack.empty()) {
            return stack.pop();
        }
        return null;
    }

    //将备忘点添加到栈中
    public void setEmpMemento(EmpMemento empMemento) {
        stack.push(empMemento);
    }
}
