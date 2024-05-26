/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

/**
 *
 * @author 박규리
 */

public class SalesReport implements Report {
    @Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("매출 현황 조회");
        System.out.println("총 매출: ");
        System.out.println("항공권별 매출: ");
    }
}
