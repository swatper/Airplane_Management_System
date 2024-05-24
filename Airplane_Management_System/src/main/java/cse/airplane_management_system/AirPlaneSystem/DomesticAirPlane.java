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
    public DomesticAirPlane(String departure, String arrival, String date) {
        super(departure, arrival, "Domestic", date, true); // 부모 클래스의 생성자 호출
    }
}

