package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.FileManager;
import cse.airplane_management_system.LoginSystem.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 박상현
 */
public class ReservationSystem {

    static ReservationSystem reservationSystem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public User loginUser;
    //public Airplane ReservAirplane;
    public FileManager fileManager;
    public static ReservationSystem reservationSystem;
    
    public String airlineName;
    
    //생성자(싱글턴 패턴)
    private ReservationSystem(){}
    
   public static ReservationSystem GetSystem(){
       if(reservationSystem == null){
           reservationSystem = new ReservationSystem();
       }
       return reservationSystem;
   }
    //시스템 초기화 작업
    public void Init(User LoginUser){
        this.loginUser = LoginUser;
        fileManager = new FileManager();
    
    }
    
    public void RunSystem() throws IOException{
        System.out.println("원하시는 메뉴를 선택하세요: 1 예약조회 2. 항공편 예약");
        BufferedReader getMenuMode = new BufferedReader(new InputStreamReader(System.in));
        int menuMode = Integer.parseInt(getMenuMode.readLine());
        switch (menuMode) {
            case 1:
                Lookup();
                break;
            case 2:
                Reservate();
                break;
            default:
                System.out.println("옳바른 메뉴를 선택해주세요. ");
                break;
        }
    }
    public void Lookup(){
    
    }
    
    public void Reservate() throws IOException{
        System.out.println("원하시는 항공사를 선택해주세요: 1. 대한항공 2. 아시아나항공 3. 부산에어 ");
        BufferedReader getAirline = new BufferedReader(new InputStreamReader(System.in));
        int AirlineNum = Integer.parseInt(getAirline.readLine());
        switch (AirlineNum) {
            case 1:
                airlineName = "KorAir";
                break;
            case 2:
                airlineName = "AsiAir";
                break;
            case 3:
                airlineName = "BusAir";
                break;
            default:
                System.out.println("옳바른 메뉴를 선택해주세요. ");
                break;
        }
        SelectSeat();
    }
    
    public void SelectSeat() throws IOException{
        System.out.println("원하시는 좌석을 선태해주세요.(1~20)");
          BufferedReader getSeatNum = new BufferedReader(new InputStreamReader(System.in));
        String SeatNum = getSeatNum.readLine();
        Reservation Res = new Reservation(loginUser.getUserID(), airlineName, SeatNum);
        
    
    }
    
}
