package DesignPattern.chainOfResponsibility;

/**
 * 领导类
 */
public abstract class Leader {
    protected String name; //领导姓名
    protected Leader nextLeader;
    public Leader(String name){
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader){
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心方法，抽象类，因为具体实现处理请求的方法要在具体的实现类中实现
     * @param request
     */
    public abstract void handleRequest(LeaveRequest request);
}


