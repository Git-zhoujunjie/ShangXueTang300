package DesignPattern.Builder;

public class ZjjAirShipDirector implements AirShipDirector {

    //通过构建者builder构建的内容进行组装direct
    private AirShipBuilder builder;
    public ZjjAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        //构建零件
        OrbitalModule o = builder.createOrbitalModule();
        Engine e = builder.createEngine();
        EscapeTower es = builder.createEscapeTower();

        //组装
        AirShip ship = new AirShip();
        ship.setOrbitalModule(o);
        ship.setEngine(e);
        ship.setEscapeTower(es);
        System.out.println("构建飞船成功");

        return ship;
    }
}
