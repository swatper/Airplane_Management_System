package cse.airplane_management_system.AirPlaneSystem;

import cse.airplane_management_system.LoginSystem.LoginSystem;
import cse.airplane_management_system.LoginSystem.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirPlaneSystem {
    private List<AirPlane> airPlanes;
    private LoginSystem loginSystem;

    public AirPlaneSystem() {
        airPlanes = new ArrayList<>();
        loginSystem = LoginSystem.GetSystem();
    }

    // 파일에서 항공편 정보 읽기
    public void loadFromFile() throws IOException {
        // 로직 생략 (기존 코드 사용)
    }

    // 파일에 항공편 정보 저장
    public void saveToFile() throws IOException {
        // 로직 생략 (기존 코드 사용)
    }

    // 새로운 항공편 추가 메서드
    public void addAirPlane(String departure, String arrival, String type, String date) {
        AirPlane newAirPlane = new AirPlane(departure, arrival, type, date);
        airPlanes.add(newAirPlane);
        System.out.println("새로운 항공편이 추가되었습니다.");
    }

    // 모든 항공편 정보 출력 메서드
    public void printAllAirPlanes() {
        if (airPlanes.isEmpty()) {
            System.out.println("등록된 항공편이 없습니다.");
            return;
        }
        System.out.println("등록된 항공편 목록:");
        for (AirPlane airPlane : airPlanes) {
            System.out.println("출발지: " + airPlane.GetDepartures() +
                    ", 도착지: " + airPlane.GetArrivals() +
                    ", 유형: " + airPlane.GetTypes() +
                    ", 날짜: " + airPlane.GetDates());
        }
    }

    // 항공편 수정 메서드
    public void updateAirPlane(int index, String departure, String arrival, String type, String date) {
        if (index >= 0 && index < airPlanes.size()) {
            AirPlane airPlane = airPlanes.get(index);
            airPlane.SetDepartures(departure);
            airPlane.SetArrivals(arrival);
            airPlane.SetTypes(type);
            airPlane.SetDates(date);
            System.out.println("항공편 정보가 수정되었습니다.");
        } else {
            System.out.println("해당 인덱스의 항공편이 존재하지 않습니다.");
        }
    }

    // 항공편 삭제 메서드
    public void deleteAirPlane(int index) {
        if (index >= 0 && index < airPlanes.size()) {
            airPlanes.remove(index);
            System.out.println("항공편이 삭제되었습니다.");
        } else {
            System.out.println("해당 인덱스의 항공편이 존재하지 않습니다.");
        }
    }

    // 관리자 확인 메서드
    private boolean isAdmin() {
        User loginUser = loginSystem.GetLoginUser();
        return loginUser != null && loginUser.isAdmin(); // LoginSystem에서 isAdmin이 true면 관리자 확인
    }

    public void RunSystem() throws IOException {
    loginSystem.Init();
    loginSystem.RunSystem();

    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("메인 메뉴:");
        System.out.println("1. 모든 항공편 조회");
        System.out.println("2. 관리자 메뉴");
        System.out.println("3. 종료");
        System.out.print("메뉴를 선택하세요: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        switch (choice) {
            case 1:
                printAllAirPlanes();
                break;
            case 2:
                if (loginSystem.GetLoginUser() != null && loginSystem.GetLoginUser().isAdmin()) {
                    runAdminMenu(scanner);
                } else {
                    System.out.println("관리자가 아닙니다.");
                }
                break;
            case 3:
                System.out.println("프로그램을 종료합니다.");
                saveToFile();
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
    }
}

private void runAdminMenu(Scanner scanner) throws IOException {
    while (true) {
        System.out.println("관리자 메뉴:");
        System.out.println("1. 새로운 항공편 추가");
        System.out.println("2. 항공편 수정");
        System.out.println("3. 항공편 삭제");
        System.out.println("4. 메인 메뉴로 돌아가기");
        System.out.print("메뉴를 선택하세요: ");
        int adminChoice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        switch (adminChoice) {
            case 1:
                System.out.print("출발지를 입력하세요: ");
                String departure = scanner.nextLine();
                System.out.print("도착지를 입력하세요: ");
                String arrival = scanner.nextLine();
                System.out.print("유형을 입력하세요: ");
                String type = scanner.nextLine();
                System.out.print("날짜를 입력하세요: ");
                String date = scanner.nextLine();
                addAirPlane(departure, arrival, type, date);
                break;
            case 2:
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
                updateAirPlane(indexToUpdate, newDeparture, newArrival, newType, newDate);
                break;
            case 3:
                System.out.print("삭제할 항공편의 인덱스를 입력하세요: ");
                int indexToDelete = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                deleteAirPlane(indexToDelete);
                break;
            case 4:
                return;
            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
     }
    }
}