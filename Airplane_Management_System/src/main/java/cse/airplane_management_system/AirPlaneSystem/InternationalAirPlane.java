/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author 가영
 */
public class InternationalAirPlane extends AirPlane {
    // InternationalAirPlane 생성자
    public InternationalAirPlane(String departure, String arrival, String date) {
        super(departure, arrival, "International", date, true); // 부모 클래스의 생성자 호출
    }
}