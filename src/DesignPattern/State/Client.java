package DesignPattern.State;

public class Client {
    public static void main(String[] args) {
        RoomContext rc = new RoomContext();

        rc.setState(new BookedState());
        rc.setState(new CheckedState());
    }
}
