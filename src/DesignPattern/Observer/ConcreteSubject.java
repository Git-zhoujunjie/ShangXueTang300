package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的通知者
 */
public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        //目标对象状态发生变化，请通知所有的观察者
        this.Notify();
    }
}
