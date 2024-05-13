/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

import java.util.Scanner;

/**
 *
 * @author kb010
 */
public class AirPlaneSyetem_TestDriver {
      public static void main(String[] args) {
        AirPlaneSystem system = new AirPlaneSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 새로운 항공편 추가");
            System.out.println("2. 모든 항공편 조회");
            System.out.println("3. 항공편 수정");
            System.out.println("4. 항공편 삭제");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    System.out.print("출발지를 입력하세요: ");
                    String departure = scanner.nextLine();
                    System.out.print("도착지를 입력하세요: ");
                    String arrival = scanner.nextLine();
                    System.out.print("유형을 입력하세요: ");
                    String type = scanner.nextLine();
                    System.out.print("날짜를 입력하세요: ");
                    String date = scanner.nextLine();
                    system.addAirPlane(departure, arrival, type, date);
                    break;
                case 2:
                    system.printAllAirPlanes();
                    break;
                case 3:
                    System.out.print("수정할 항공편의 인덱스를 입력하세요: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("새로운 출발지를 입력하세요: ");
                    String newDeparture = scanner.nextLine();
                    System.out.print("새로운 도착지를 입력하세요: ");
                    String newArrival = scanner.nextLine();
                    System.out.print("새로운 유형을 입력하세요: ");
                    String newType = scanner.nextLine();
                    System.out.print("새로운 날짜를 입력하세요: ");
                    String newDate = scanner.nextLine();
                    system.updateAirPlane(indexToUpdate, newDeparture, newArrival, newType, newDate);
                    break;
                case 4:
                    System.out.print("삭제할 항공편의 인덱스를 입력하세요: ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    system.deleteAirPlane(indexToDelete);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}