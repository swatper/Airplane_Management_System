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


public class UserMenuStrategy implements MenuStrategy {
    private AirPlaneSystem airPlaneSystem;

    public UserMenuStrategy(AirPlaneSystem airPlaneSystem) {
        this.airPlaneSystem = airPlaneSystem;
    }

    @Override
    public void showMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("======================================");
            System.out.println("사용자 메뉴");
            System.out.println("1. 모든 항공편 조회");
            System.out.println("2. 예약하기");
            System.out.println("3. 메인 메뉴로 돌아가기");
            System.out.print("메뉴를 선택하세요: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (userChoice) {
                case 1:
                    airPlaneSystem.printAllAirPlanes();
                    break;
                case 2:
                    airPlaneSystem.StartReservate();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
}