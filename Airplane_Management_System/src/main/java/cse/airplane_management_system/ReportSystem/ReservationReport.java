/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import java.util.List;
import java.util.ArrayList; // ArrayList import 추가

/**
 *
 * @author 박규리
 */

public class ReservationReport implements Report {
    private List<AirPlane> airplanes;

    // 매개변수 없는 생성자 추가
    public ReservationReport() {
        this.airplanes = new ArrayList<>(); // airplanes를 새 ArrayList로 초기화
    }

    // 생성자에서 List<AirPlane>을 받도록 변경
    public ReservationReport(List<AirPlane> airplanes) {
        this.airplanes = airplanes;
    }

    @Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("예약 현황 조회");

        int totalReservations = 0; // 총 예약 건수 초기화

        // 각 항공편별 예약 현황 출력 및 총 예약 건수 계산
        for (AirPlane airplane : airplanes) {
            int reservedSeats = countReservedSeats(airplane); // 항공편별 예약된 좌석 수 계산
            totalReservations += reservedSeats; // 총 예약 건수 누적

            System.out.println("항공편: " + airplane.getDepartures() + " -> " + airplane.getArrivals() +
                               ", 예약된 좌석 수: " + reservedSeats);
        }

        System.out.println("총 예약 건수: " + totalReservations);
    }

    // 항공편별 예약된 좌석 수를 계산하는 메서드
    private int countReservedSeats(AirPlane airplane) {
        int reservedSeats = 0;

        for (Boolean seat : airplane.getSeats()) {
            if (seat) {
                reservedSeats++;
            }
        }

        return reservedSeats;
    }
}
