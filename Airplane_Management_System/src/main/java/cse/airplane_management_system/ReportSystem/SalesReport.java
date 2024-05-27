/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 박규리
 */

public class SalesReport implements Report {
    private List<AirPlane> airplanes;

    public SalesReport() {
        this.airplanes = loadAirplanes(); // 항공편 리스트를 로드
    }

    private List<AirPlane> loadAirplanes() {
        List<AirPlane> airplanes = new ArrayList<>();
        
        // 예시로 실제 데이터를 불러온다고 가정
        // 실제 구현에서는 데이터베이스나 외부 데이터 소스에서 데이터를 가져와야 함
        List<Boolean> seats1 = List.of(true, false, true, true, false); // 3개의 좌석 예약됨
        List<Boolean> seats2 = List.of(true, true, true, true, true); // 5개의 좌석 예약됨
        
        AirPlane airplane1 = new AirPlane("Seoul", "Busan", "Korean Air", "2023-05-01", true, 200);
        airplane1.setSeats(new ArrayList<>(seats1)); // 좌석 정보 설정
        airplane1.setPrice(200);
        
        AirPlane airplane2 = new AirPlane("Incheon", "New York", "Asiana", "2023-05-01", false, 150);
        airplane2.setSeats(new ArrayList<>(seats2)); // 좌석 정보 설정
        airplane2.setPrice(150);
        
        airplanes.add(airplane1);
        airplanes.add(airplane2);
        
        return airplanes;
    }

    @Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("매출 현황 조회");
        int totalSales = 0;
        for (AirPlane airplane : airplanes) {
            int airplaneTotalPrice = airplane.getTotalprice();
            totalSales += airplaneTotalPrice;
            System.out.println("항공편 ID: " + airplane.hashCode() + ", 매출: " + airplaneTotalPrice);
        }
        System.out.println("총 매출: " + totalSales);
    }
}
