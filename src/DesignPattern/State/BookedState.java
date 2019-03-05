package DesignPattern.State;

/**
 * 具体的状态类
 */
public class BookedState implements State {
    @Override
    public void getState() {
        System.out.println("房间已预订，预定房客可以入住！");
    }
}
