/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author 가영
 */
public class DomesticAirPlane extends AirPlane {
    // DomesticAirPlane 생성자
    public DomesticAirPlane(String departure, String arrival, String airline, String date, int price) {
        super(departure, arrival, airline, date, true, price);
    }

    @Override
    public boolean isDomestic() {
        return true;
    }
}