package cse.airplane_management_system.AirPlaneSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 박상현
 */


public class AirPlaneSystem {
    private List<AirPlane> airPlanes;

    public AirPlaneSystem() {
        airPlanes = new ArrayList<>();
    }

    // 새로운 항공편 추가 메서드
    public void addAirPlane(String departure, String arrival, String type, String date) {
        AirPlane newAirPlane = new AirPlane(departure, arrival, type, date);
        airPlanes.add(newAirPlane);
        System.out.println("새로운 항공편이 추가되었습니다.");
        saveToFile(); // 파일에 저장
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
            saveToFile(); // 파일에 저장
        } else {
            System.out.println("해당 인덱스의 항공편이 존재하지 않습니다.");
        }
    }

    // 항공편 삭제 메서드
    public void deleteAirPlane(int index) {
        if (index >= 0 && index < airPlanes.size()) {
            airPlanes.remove(index);
            System.out.println("항공편이 삭제되었습니다.");
            saveToFile(); // 파일에 저장
        } else {
            System.out.println("해당 인덱스의 항공편이 존재하지 않습니다.");
        }
    }

    // 파일에 항공편 정보 저장
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Airplane.txt"))) {
            for (AirPlane airPlane : airPlanes) {
                writer.println(airPlane.GetDepartures() + "," + airPlane.GetArrivals() + "," +
                        airPlane.GetTypes() + "," + airPlane.GetDates());
            }
        } catch (IOException e) {
            System.err.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    // 파일로부터 항공편 정보 읽어오기
    public void loadFromFile() {
        try (Scanner scanner = new Scanner(new File("Airplane.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 4) {
                    addAirPlane(parts[0], parts[1], parts[2], parts[3]);
                } else {
                    System.err.println("잘못된 파일 형식입니다.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다.");
        }
    }

    public void RunSystem() throws IOException {
        AirPlaneSystem system = new AirPlaneSystem();
        // 파일에서 항공편 정보 읽어오기
        system.loadFromFile();

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