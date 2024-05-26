/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

/**
 *
 * @author 박규리
 */
// 만족도 및 피드백 조회

public class FeedbackReport implements Report {
    @Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("만족도 및 피드백 조회");
        System.out.println("평균 만족도 점수: ");
        System.out.println("피드백: ");
    }
}
