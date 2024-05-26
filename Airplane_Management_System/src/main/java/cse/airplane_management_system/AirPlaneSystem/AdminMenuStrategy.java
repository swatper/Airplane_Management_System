/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author kb010
 */

import java.io.IOException;
import java.util.Scanner;

public class AdminMenuStrategy implements MenuStrategy {
    private AirPlaneSystem airPlaneSystem;

    public AdminMenuStrategy(AirPlaneSystem airPlaneSystem) {
        this.airPlaneSystem = airPlaneSystem;
    }

    @Override
    public void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======================================");
            System.out.println("관리자 메뉴");
            System.out.println("1. 새로운 항공편 추가");
            System.out.println("2. 항공편 수정");
            System.out.println("3. 항공편 삭제");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.print("메뉴를 선택하세요: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (adminChoice) {
                case 1:
                    airPlaneSystem.addAirPlane(scanner);
                    break;
                case 2:
                    System.out.print("수정할 항공편의 인덱스를 입력하세요: ");
                 int indexToUpdate = scanner.nextInt();
                 scanner.nextLine(); // 버퍼 비우기
                    System.out.print("새로운 출발지를 입력하세요: ");
                    String newDeparture = scanner.nextLine();
                    System.out.print("새로운 도착지를 입력하세요: ");
                    String newArrival = scanner.nextLine();
                    System.out.print("새로운 날짜를 입력하세요: ");
                    String newDate = scanner.nextLine();
                    System.out.print("새로운 가격을 입력하세요: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("새로운 항공사명을 입력하세요: ");
                    String newAirline = scanner.nextLine(); // 새로운 항공사명 입력 추가
                    airPlaneSystem.updateAirPlane(indexToUpdate, newDeparture, newArrival, newAirline, newDate, newPrice);
    break;
                case 3:
                    System.out.print("삭제할 항공편의 인덱스를 입력하세요: ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    airPlaneSystem.deleteAirPlane(indexToDelete);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}