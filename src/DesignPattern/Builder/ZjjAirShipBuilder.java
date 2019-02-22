package DesignPattern.Builder;

/**
 * 构建具体的飞船
 */
public class ZjjAirShipBuilder implements AirShipBuilder{
    @Override
    public OrbitalModule createOrbitalModule() {
        System.out.println("构建轨道舱成功");
        return new OrbitalModule("周俊杰轨道舱");
    }

    @Override
    public Engine createEngine() {
        System.out.println("构建发动机成功");
        return new Engine("周俊杰发动机");
    }

    @Override
    public EscapeTower createEscapeTower() {
        System.out.println("构建逃逸塔成功");
        return new EscapeTower("周俊杰逃逸塔");
    }
}
