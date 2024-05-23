package cse.airplane_management_system.AirPlaneSystem;

import cse.airplane_management_system.LoginSystem.LoginSystem;
import cse.airplane_management_system.LoginSystem.User;
import cse.airplane_management_system.ReservationSystem.ReservationSystem;
import cse.airplane_management_system.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirPlaneSystem {
    private List<AirPlane> airPlanes;
    private User loginUser;
    private ReservationSystem reservationSystem;
    private FileManager fileManager;
    private static final int DB_TYPE = 1; // 항공기 시스템 DB 타입

    public AirPlaneSystem() throws IOException {
        airPlanes = new ArrayList<>();
        this.reservationSystem = ReservationSystem.GetSystem(loginUser);
        reservationSystem.Init();
        fileManager = new FileManager();
        loadFromFile();
    }

   // 파일에서 항공편 정보 읽기
    public void loadFromFile() {
        try {
            ArrayList<String> fileContents = fileManager.readDBFile(DB_TYPE);
            for (String line : fileContents) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    airPlanes.add(new AirPlane(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]));
                } else {
                    System.err.println("잘못된 파일 형식입니다.");
                }
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
    }

    // 파일에 항공편 정보 저장
    public void saveToFile() throws IOException {
        try {
            fileManager.writeDBFile(DB_TYPE, airPlanes);
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

     // 새로운 항공편 추가 메서드
    public void addAirPlane(String departure, String arrival, String type, String date, int price, String name) {
        AirPlane newAirPlane = new AirPlane(departure, arrival, type, date, price, name);
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
        int airplaneIndex = 1;
        for (AirPlane airPlane : airPlanes) {
            System.out.println(airplaneIndex + ". 출발지: " + airPlane.GetDepartures() +
                    ", 도착지: " + airPlane.GetArrivals() +
                    ", 유형: " + airPlane.GetTypes() +
                    ", 날짜: " + airPlane.GetDates() +
                    ", 가격: " + airPlane.GetPrice() +
                    ", 항공사명: " + airPlane.GetName());
            airplaneIndex++;
        }
    }

      // 항공편 수정 메서드
    public void updateAirPlane(int index, String departure, String arrival, String type, String date, int price, String name) {
        if (index >= 0 && index < airPlanes.size()) {
            AirPlane airPlane = airPlanes.get(index);
            airPlane.SetDepartures(departure);
            airPlane.SetArrivals(arrival);
            airPlane.SetTypes(type);
            airPlane.SetDates(date);
            airPlane.SetPrice(price);
            airPlane.SetName(name);
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

    //실행 메서드
    public void RunSystem(User GetUser) throws IOException {
    this.loginUser = GetUser;
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("======================================");
        System.out.println("메인 메뉴");
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
                if (loginUser.isAdmin()) {
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

   // 관리자 메뉴 실행 메서드
    private void runAdminMenu(Scanner scanner) throws IOException {
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
                    System.out.print("출발지를 입력하세요: ");
                    String departure = scanner.nextLine();
                    System.out.print("도착지를 입력하세요: ");
                    String arrival = scanner.nextLine();
                    System.out.print("유형을 입력하세요: ");
                    String type = scanner.nextLine();
                    System.out.print("날짜를 입력하세요: ");
                    String date = scanner.nextLine();
                    System.out.print("가격을 입력하세요: ");
                    int price = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("항공사명을 입력하세요: ");
                    String name = scanner.nextLine();
                    addAirPlane(departure, arrival, type, date, price, name);
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
                    System.out.print("새로운 가격을 입력하세요: ");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("새로운 항공사명을 입력하세요: ");
                    String newName = scanner.nextLine();
                    updateAirPlane(indexToUpdate, newDeparture, newArrival, newType, newDate, newPrice, newName);
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