/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author 가영
 */
public class AirPlaneFactory {
    // 정적 팩토리 메서드
    public static AirPlane createAirPlane(String type, String departure, String arrival, String date) {
        // 입력된 유형에 따라 객체 생성
        if(type.equalsIgnoreCase("Domestic")){
            return new DomesticAirPlane(departure, arrival, date); //DomesticAirPlane 객체 반환
        } else if (type.equalsIgnoreCase("International")) {
            return new InternationalAirPlane(departure, arrival, date); //InternationalAirPlane 객체 반환
        }
        // 잘못된 유형 입력 시 예외 발생
        throw new IllegalArgumentException("Invalid type: "+type);
        }
    
    }
