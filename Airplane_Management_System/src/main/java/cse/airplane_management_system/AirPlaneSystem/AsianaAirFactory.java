/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author 가영
 */
public class AsianaAirFactory implements AirPlaneFactory {
    @Override
    public AirPlane createDomesticAirPlane(String departure, String arrival, String date, int price) {
        return new DomesticAirPlane(departure, arrival, "Asiana Airlines", date, price);
    }
    
    @Override
    public AirPlane createInternationalAirPlane(String departure, String arrival, String date, int price){
        return new InternationalAirPlane(departure, arrival, "Asiana Airlines", date, price);
    }
}
