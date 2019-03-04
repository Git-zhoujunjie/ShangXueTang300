package DesignPattern.Mediator;

/**
 * 中介者接口
 * 包含添加对应管理者的register方法
 * 和根据对应管理者提出的要求再对要求下发到对应部门的command方法
 */
public interface Mediator {
    void register(String name,Department d); //将要管理的对象添加进来
    void command(String name);  //向对应部门发送命令
}
