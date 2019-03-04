package DesignPattern.chainOfResponsibility;

public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if(request.getDays()<3){
            System.out.println("员工："+request.getName()+"请假天数："+request.getDays()+"请假原因："+request.getReason());
            System.out.println("主任："+this.name+"审批通过！");
        }else{
            if(this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
