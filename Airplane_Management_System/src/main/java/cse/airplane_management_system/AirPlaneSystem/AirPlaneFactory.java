/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author 가영
 */
// 추상 팩토리 클래스
public abstract class AirPlaneFactory {
    public abstract AirPlane createAirPlane(String departure, String arrival, String airline, String date);
}

// DomesticAirPlaneFactory 클래스
class DomesticAirPlaneFactory extends AirPlaneFactory {
    @Override
    public AirPlane createAirPlane(String departure, String arrival, String airline, String date) {
        return new DomesticAirPlane(departure, arrival, airline, date);
    }
}

// InternationalAirPlaneFactory 클래스
class InternationalAirPlaneFactory extends AirPlaneFactory {
    @Override
    public AirPlane createAirPlane(String departure, String arrival, String airline, String date) {
        return new InternationalAirPlane(departure, arrival, airline, date);
    }
}
