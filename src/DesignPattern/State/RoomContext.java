package DesignPattern.State;

/**
 * 状态切换类
 * 该类相当于银行中的账户，系统根据账户余额对账户设置账户相应的状态
 */
public class RoomContext {
    private State state;

    public RoomContext(){  //初始化时设置房间为空闲状态
        state = new FreeState();
        state.getState();
    }

    //状态切换
    public void setState(State s){
        System.out.println("房间状态切换。。。");
        state = s;
        state.getState();
    }
}
