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
            System.out.println("5. 보고서");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.print("메뉴를 선택하세요: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

                switch (adminChoice) {
                case 1:
                    System.out.println("항공편 유형을 선택하세요");
                    System.out.println("1. 국내선");
                    System.out.println("2. 국제선");
                    System.out.print("선택: ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    String type;
                    if (typeChoice == 1) {
                        type = "Domestic";
                    } else if (typeChoice == 2) {
                        type = "International";
                    } else {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    System.out.println("항공사를 선택하세요:");
                    System.out.println("1. 대한 항공");
                    System.out.println("2. 아시아나 항공");
                    System.out.println("3. 제주 항공");
                    System.out.print("선택: ");
                    int airlineChoice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    String airline;
                    if (airlineChoice == 1) {
                        airline = "대한 항공";
                    } else if (airlineChoice == 2) {
                        airline = "아시아나 항공";
                    } else if (airlineChoice == 3) {
                        airline = "제주 항공";
                    } else {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    System.out.print("출발지를 입력하세요: ");
                    String departure = scanner.nextLine();
                    System.out.print("도착지를 입력하세요: ");
                    String arrival = scanner.nextLine();
                    System.out.print("날짜를 입력하세요: ");
                    String date = scanner.nextLine();
                    scanner.nextLine(); // 버퍼 비우기

                    airPlaneSystem.addAirPlane(departure, arrival, type, airline, date);
                    break;

                case 2:
                    System.out.print("수정할 항공편의 인덱스를 입력하세요: ");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    System.out.println("항공편 유형을 선택하세요:");
                    System.out.println("1. 국내선");
                    System.out.println("2. 국제선");
                    System.out.print("선택: ");
                    typeChoice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    if (typeChoice == 1) {
                        type = "Domestic";                    
                    } else if (typeChoice == 2) {
                        type = "International";                   
                    } else {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    System.out.println("항공사를 선택하세요:");
                    System.out.println("1. 대한 항공");
                    System.out.println("2. 아시아나 항공");
                    System.out.println("3. 제주 항공");
                    System.out.print("선택: ");
                    airlineChoice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    String newAirline; // 변수 선언
                    if (airlineChoice == 1) {
                        newAirline = "대한 항공";                    
                    } else if (airlineChoice == 2) {
                        newAirline = "아시아나 항공";
                    } else if (airlineChoice == 3) {
                        newAirline = "제주 항공";
                    } else {
                        System.out.println("잘못된 선택입니다.");
                        break;
                    }

                    System.out.print("새로운 출발지를 입력하세요: ");
                    String newDeparture = scanner.nextLine();
                    System.out.print("새로운 도착지를 입력하세요: ");
                    String newArrival = scanner.nextLine();
                    System.out.print("새로운 날짜를 입력하세요: ");
                    String newDate = scanner.nextLine();
                    System.out.print("새로운 가격을 입력하세요: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기

                    airPlaneSystem.updateAirPlane(indexToUpdate, newDeparture, newArrival, newAirline, newDate, newPrice);
                    break;
                    
                case 3:
                    System.out.print("삭제할 항공편의 인덱스를 입력하세요: ");
                    int indexToDelete = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    airPlaneSystem.deleteAirPlane(indexToDelete);
                    break;
                case 4:
                    airPlaneSystem.StartReport();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}