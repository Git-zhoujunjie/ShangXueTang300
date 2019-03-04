package DesignPattern.chainOfResponsibility;

public class ViceGeneralManager extends Leader {
    public ViceGeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays()<15){
            System.out.println("员工："+request.getName()+"请假天数："+request.getDays()+"请假原因："+request.getReason());
            System.out.println("副总经理："+this.name+"审批通过！");
        }else{
            this.nextLeader.handleRequest(request);
        }
    }
}
