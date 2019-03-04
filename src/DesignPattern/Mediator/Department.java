package DesignPattern.Mediator;

/**
 * 同事类的接口
 *
 */
public interface Department {
    void selfAction();  //本部门事情
    void outAction();  //向总经理申请事情
}
