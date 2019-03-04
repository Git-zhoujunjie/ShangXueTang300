package DesignPattern.Command;

public class Client {
    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());

        new Invoke(command).call();

        //new Receiver().action();


    }
}
