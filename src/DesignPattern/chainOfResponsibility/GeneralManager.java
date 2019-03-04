package DesignPattern.chainOfResponsibility;

public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays()<20){
            System.out.println("员工："+request.getName()+"请假天数："+request.getDays()+"请假原因："+request.getReason());
            System.out.println("总经理："+this.name+"审批通过！");
        }else{
            //没有下一个节点
            System.out.println("员工："+request.getName()+"是不是想辞职？！");
        }
    }
}
