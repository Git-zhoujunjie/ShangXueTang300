package DesignPattern.Builder;

/**
 * 构建者
 */
public interface AirShipBuilder {
    OrbitalModule createOrbitalModule();
    Engine createEngine();
    EscapeTower createEscapeTower();
}
