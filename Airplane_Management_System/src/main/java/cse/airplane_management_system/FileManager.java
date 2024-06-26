package cse.airplane_management_system;

import cse.airplane_management_system.LoginSystem.User;
import cse.airplane_management_system.ReservationSystem.Reservation;
import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; 

/**
 * @author 박상현
 */
public class FileManager {
    //파일 생성 메소드

    public void createDBFile(int typeOfDB, String path) throws IOException {
        String File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\" + path + "\\"; //파일 경로
        String File_Name;

        switch (typeOfDB) {
            //로그인 시스템
            case 0:
                File_Name = "User.txt";
                break;
            //항공기 시스템
            case 1:
                File_Name = "Airplane.txt";
                break;
            //예약 시스템
            case 2:
                File_Name = "Reservation.txt";
                break;
            //보고서 시스템
            case 3:
                File_Name = "Review.txt";
                break;
            default:
                return;
        }

        File_Path = File_Path + File_Name;
        File Create_File = new File(File_Path);//File 객체 생성

        // 파일이 존재하지 않으면 파일 생성
        if (!Create_File.exists()) {
            Create_File.createNewFile();
        }
    }

    //파일 읽어서 StringAttay로 전달하는 메소드
    public ArrayList<String> readDBFile(int typeOfDB) throws IOException {
        String File_Path;
        File Read_File;
        ArrayList<String> readContext = new ArrayList<>();
        //경로 설정
        switch (typeOfDB) {
            //로그인 시스템
            case 0:
                File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\LoginSystem\\User.txt";
                break;
            //항공기 시스템
            case 1:
                File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\AirPlaneSystem\\Airplane.txt";
                break;
            //예약 시스템
            case 2:
                File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\ReservationSystem\\Reservation.txt";
                break;
            //보고서 시스템
            default:
                System.out.println("파일 읽기 타임 잘못됨");
                return null;
        }
        //파일 내용 읽기
        Read_File = new File(File_Path);
        BufferedReader Buf_reader = new BufferedReader(new FileReader(Read_File));
        String File_Contents;
        while ((File_Contents = Buf_reader.readLine()) != null) {
            //파일 내용을 String형의 배열로 저장
            readContext.add(File_Contents);
        }
        //String  배열 넘겨줌
        return readContext;
    }

    //객체를 받아 객체의 정보를 파일에 저장하는 메서드
    public void writeDBFile(int typeOfDB, Object DBList) throws IOException {
        String File_Path;
        FileWriter write;
        ArrayList<String> writeLine = new ArrayList<>();
        switch (typeOfDB) {
            //로그인 시스템
            case 0:
                File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\LoginSystem\\User.txt";
                write = new FileWriter(File_Path, false);
                ArrayList<User> userWriter = (ArrayList<User>) DBList;
                for (User temp : userWriter) {
                    //객체 정보 직렬화
                    writeLine.add(temp.getUserID() + ";" + temp.getUserPassword() + ";" + temp.getUserName() + ";"
                            + temp.getUserAge() + ";" + temp.getUserGender() + ";" + temp.getUserAddress() + "\n");
                }
                //파일에 저장
                for (String writeContext : writeLine) {
                    write.write(writeContext);
                }
                write.flush();
                write.close();
                break;
            // 항공기 시스템
            case 1:
             File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\AirPlaneSystem\\Airplane.txt";
             write = new FileWriter(File_Path, false);
             ArrayList<AirPlane> airplaneWriter = (ArrayList<AirPlane>) DBList;
                for (AirPlane temp : airplaneWriter) {
                    String type = temp.isDomestic() ? "Domestic" : "International";
                    writeLine.add(temp.getDepartures() + ";" + temp.getArrivals() + ";" + temp.getAirlines() + ";"+type + ";" + temp.getDates() + ";" + temp.getPrice() + "\n");
                }
                //파일에 저장
                for (String writeContext : writeLine) {
                    write.write(writeContext);
                }
                write.flush();
                write.close();
                break;
            //예약 시스템
            case 2:
               File_Path = System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\ReservationSystem\\Reservation.txt";
                write = new FileWriter(File_Path, false);
                ArrayList<Reservation> reservationWriter = (ArrayList<Reservation>) DBList;
                for (Reservation temp : reservationWriter) {
                    //객체 정보 직렬화
                    writeLine.add(temp.GetBookedAirline() +";" + temp.GetBookedAirlineDate()+";" + temp.GetBookedUserID() + ";"+ temp.GetBookedUserName() + ";" + 
                            temp.GetPhoneNumber() + ";" + temp.GetBookedSeatNum()+ "\n");
                }
                //파일에 저장
                for (String writeContext : writeLine) {
                    write.write(writeContext);
                }
                
                write.flush();
                write.close();
                break;

            //보고서 시스템
        }
    }
}
