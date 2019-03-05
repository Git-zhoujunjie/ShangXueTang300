package DesignPattern.State;

/**
 * 具体的状态类
 */
public class FreeState implements State {
    @Override
    public void getState() {
        System.out.println("房间空闲，可以预定！");
    }
}
