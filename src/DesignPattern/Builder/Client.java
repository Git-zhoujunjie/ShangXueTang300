package DesignPattern.Builder;


public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new ZjjAirShipDirector(new ZjjAirShipBuilder());

        AirShip ship = director.directAirShip();

        System.out.println(ship.getOrbitalModule().getName());
        ship.launch();
    }
}
