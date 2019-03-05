package DesignPattern.Observer;

public class ObserverA implements Observers {

    private int myState;  //myState需要和目标对象的状态值一致

    @Override
    public void update(Subject sj) {
        myState = sj.getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
