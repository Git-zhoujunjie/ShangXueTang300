package DesignPattern.State;

/**
 * 具体的状态类
 */
public class CheckedState implements State {
    @Override
    public void getState() {
        System.out.println("房间入住，不能预订！");
    }
}
