package DesignPattern.Mediator;

import java.util.HashMap;
import java.util.Map;

public class President implements Mediator{

    private Map<String,Department> map = new HashMap<>();
    @Override
    public void register(String name, Department d) {
        map.put(name,d);   //经对应的部门添加到容器中
    }

    @Override
    public void command(String name) {
        map.get(name).selfAction();   //根据各部门提出的需求，总经理向相应的部门发出命令
    }
}
