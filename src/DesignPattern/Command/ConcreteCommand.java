package DesignPattern.Command;

public class ConcreteCommand implements Command {
    private Receiver r ; //命令真正的执行者

    public ConcreteCommand(Receiver r) {  //传入具体的执行者
        this.r = r;
    }

    @Override
    public void execute() {
        //这里可以在命令执行前进行相应的处理，比如日志记录
        r.action();
        //这里可以在命令执行后进行相应的处理，比如日志记录
    }
}
