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

    public SalesReport(List<AirPlane> TargetDB) {
        this.airplanes = loadAirplanes(TargetDB); // 항공편 리스트를 로드
    }

    private List<AirPlane> loadAirplanes(List<AirPlane> TargetDB) {
        List<AirPlane> airplanes =TargetDB;
        
        // 예시로 실제 데이터를 불러온다고 가정
        // 실제 구현에서는 데이터베이스나 외부 데이터 소스에서 데이터를 가져와야 함
        List<Boolean> seats1 = List.of(true, false, true, true, false); // 3개의 좌석 예약됨
        
        AirPlane airplane1 = new AirPlane("Seoul", "Busan", "Korean Air", "2023-05-01", true, 200);
        airplane1.setSeats(new ArrayList<>(seats1)); // 좌석 정보 설정
        airplane1.setPrice(200);
        
        airplanes.add(airplane1);
        
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
            System.out.println("매출: " + airplaneTotalPrice);
        }
        System.out.println("총 매출: " + totalSales);
    }
}
