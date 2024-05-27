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
public interface AirPlaneFactory {
    AirPlane createDomesticAirPlane(String departure, String arrival, String date);
    AirPlane createInternationalAirPlane(String departure, String arrival, String date);
}

