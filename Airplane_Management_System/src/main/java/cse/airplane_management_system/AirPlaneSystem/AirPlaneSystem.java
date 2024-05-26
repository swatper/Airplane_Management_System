package cse.airplane_management_system.AirPlaneSystem;

import cse.airplane_management_system.FileManager;
import cse.airplane_management_system.LoginSystem.User;
import cse.airplane_management_system.ReservationSystem.ReservationSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirPlaneSystem {
    private List<AirPlane> airPlanes; // 모든 항공편 목록
    private User loginUser; // 로그인된 사용자
    private ReservationSystem reservationSystem; // 예약 시스템
    private FileManager fileManager; // 파일 매니저

    public AirPlaneSystem() throws IOException {
        airPlanes = new ArrayList<>();
        this.fileManager = new FileManager();
        this.reservationSystem = ReservationSystem.GetSystem(loginUser);
        reservationSystem.Init();
    }

    // 파일에서 항공편 정보 읽기
    public void loadFromFile() throws IOException {
        List<String> lines = fileManager.readDBFile(1); // 1은 항공기 시스템을 나타냄
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 6) { // 수정: 5에서 6으로 변경
                String departure = parts[0];
                String arrival = parts[1];
                String airline = parts[2];
                String date = parts[3];
                int price = Integer.parseInt(parts[4]);
                boolean isDomestic = Boolean.parseBoolean(parts[5]);
                AirPlane airPlane;
                if (isDomestic) {
                    airPlane = new DomesticAirPlane(departure, arrival, airline, date, price);
                } else {
                    airPlane = new InternationalAirPlane(departure, arrival, airline, date, price);
                }
                airPlanes.add(airPlane);
            }
        }
    }

    // 파일에 항공편 정보 저장
    public void saveToFile() throws IOException {
        fileManager.writeDBFile(1, airPlanes); // 1은 항공기 시스템을 나타냄
    }

    // 새로운 항공편 추가 메서드
    public void addAirPlane(String departure, String arrival, String type, String airline, String date, int price) {
        AirPlaneFactory factory;
        switch (airline) {
            case "대한 항공":
                factory = new KoreanAirFactory();
                break;
            case "아시아나 항공":
                factory = new AsianaAirFactory();
                break;
            case "제주 항공":
                factory = new JejuAirFactory();
                break;
            default:
                System.out.println("잘못된 항공사입니다.");
                return;
        }

        AirPlane airPlane;
        if (type.equalsIgnoreCase("Domestic")) {
            airPlane = factory.createDomesticAirPlane(departure, arrival, date, price);
        } else if (type.equalsIgnoreCase("International")) {
            airPlane = factory.createInternationalAirPlane(departure, arrival, date, price);
        } else {
            System.out.println("잘못된 항공편 유형입니다.");
            return;
        }

        airPlanes.add(airPlane);
        System.out.println("새로운 항공편이 추가되었습니다.");
        try {           //파일에 저장
            saveToFile();
        } catch (IOException e) {
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다: " + e.getMessage());
        }
    }

    // 모든 항공편 정보 출력 메서드
    public void printAllAirPlanes() {
        if (airPlanes.isEmpty()) {
            System.out.println("등록된 항공편이 없습니다.");
            return;
        }
        System.out.println("모든 항공편 목록:");
        System.out.println("======================================");
        System.out.println("국내선 항공편 목록:");
        printDomesticAirPlanes();
        System.out.println("======================================");
        System.out.println("국제선 항공편 목록:");
        printInternationalAirPlanes();
    }

    // 국내선 항공편 정보 출력 메서드
    public void printDomesticAirPlanes() {
        if (airPlanes.isEmpty()) {
            System.out.println("등록된 국내선 항공편이 없습니다.");
            return;
        }
        int domesticAirplaneIndex = 1;
        for (AirPlane airPlane : airPlanes) {
            if (airPlane.isDomestic()) {
                System.out.println(domesticAirplaneIndex + ". 출발지: " + airPlane.getDepartures() +
                        ", 도착지: " + airPlane.getArrivals() +
                        ", 항공사: " + airPlane.getAirlines() +
                        ", 날짜: " + airPlane.getDates() +
                        ", 가격: " + airPlane.getPrice());
                domesticAirplaneIndex++;
            }
        }
    }

    // 국제선 항공편 정보 출력 메서드
    public void printInternationalAirPlanes() {
        if (airPlanes.isEmpty()) {
            System.out.println("등록된 국제선 항공편이 없습니다.");
            return;
        }
        int internationalAirplaneIndex = 1;
        for (AirPlane airPlane : airPlanes) {
            if (!airPlane.isDomestic()) {
                System.out.println(internationalAirplaneIndex + ". 출발지: " + airPlane.getDepartures() +
                        ", 도착지: " + airPlane.getArrivals() +
                        ", 항공사: " + airPlane.getAirlines() +
                        ", 날짜: " + airPlane.getDates() +
                        ", 가격: " + airPlane.getPrice());
                internationalAirplaneIndex++;
            }
        }
    }

    // 항공편 수정 메서드
    public void updateAirPlane(int index, String departure, String arrival, String airline, String date, int price) {
        if (index >= 0 && index < airPlanes.size()) {
            AirPlane airPlane = airPlanes.get(index);
            airPlane.setDepartures(departure);
            airPlane.setArrivals(arrival);
            airPlane.setAirlines(airline);
            airPlane.setDates(date);
            airPlane.setPrice(price);
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

    // 실행 메서드
    public void RunSystem(User GetUser) throws IOException {
        this.loginUser = GetUser;
        MenuContext menuContext = new MenuContext();

        if (loginUser.isAdmin()) {
            menuContext.setStrategy(new AdminMenuStrategy(this));
        } else {
            menuContext.setStrategy(new UserMenuStrategy(this));
        }

        menuContext.executeStrategy();
    }
}

    // 전략패턴 적용 전  기존 실행 메서드
    /* 
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
*/                    