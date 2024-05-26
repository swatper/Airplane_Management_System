/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 박규리
 */
public class ReportSystem {
    public void runSystem() {
        try (BufferedReader getMenu = new BufferedReader(new InputStreamReader(System.in))) {
            boolean running = true;
            while (running) {
                System.out.println("======================================");
                System.out.println("원하는 메뉴를 선택하세요: 1. 매출 현황 조회  2. 예약 현황 조회  3. 만족도 및 피드백 조회  4. 종료");
                int menuMode = Integer.parseInt(getMenu.readLine());

                switch (menuMode) {
                    case 1:
                        generateReport("Sales");
                        break;
                    case 2:
                        generateReport("Reservation");
                        break;
                    case 3:
                        generateReport("Feedback");
                        break;
                    case 4:
                        System.out.println("시스템을 종료합니다.");
                        running = false;
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport(String reportType) {
        Report report = ReportFactory.createReport(reportType);
        report.generateReport();
    }
}

