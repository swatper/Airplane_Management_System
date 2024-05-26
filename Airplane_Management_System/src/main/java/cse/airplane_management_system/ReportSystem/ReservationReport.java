/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

/**
 *
 * @author 박규리
 */
// 예약 현황 조회

public class ReservationReport implements Report {
    @Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("예약 현황 조회");
        System.out.println("총 예약 건수: ");
        System.out.println("항공권별 예약: ");
    }
}

