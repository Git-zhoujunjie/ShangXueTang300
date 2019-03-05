package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主体对象
 */
public abstract class Subject {
    protected List<Observers> list = new ArrayList<>();

    //通知观察者更新所有的状态
    public void Notify() {
        for(Observers s:list){
            s.update(this);
        }
    }

    public void Register(Observers s) {
        list.add(s);
    }

    public void Remove(Observers s) {
        list.remove(s);
    }

    public abstract int getState();
}
