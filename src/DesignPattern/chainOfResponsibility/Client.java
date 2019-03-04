package DesignPattern.chainOfResponsibility;


public class Client {
    public static void main(String[] args) {
        Leader l1 = new Director("张三");
        Leader l2 = new Manager("李四");
        Leader l3 = new GeneralManager("王五");

        Leader l22 = new ViceGeneralManager("赵柳");

        LeaveRequest lr = new LeaveRequest("六六",12,"回老家。。");

        //设置责任链对象关系
        l1.setNextLeader(l2);
        l2.setNextLeader(l22);
        l22.setNextLeader(l3);

        //从入口处进行处理
        l1.handleRequest(lr);
    }
}
