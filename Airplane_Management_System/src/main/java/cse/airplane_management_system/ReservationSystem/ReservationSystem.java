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
    public User loginUser;
    //public Airplane ReservAirplane;
    public FileManager fileManager;
    public static ReservationSystem reservationSystem;
    
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
        System.out.println("예약하실 항공편을 선택해 주세요. ");
        BufferedReader GetAirplaneNum = new BufferedReader(new InputStreamReader(System.in));
        int AirplaneNum = Integer.parseInt(GetAirplaneNum.readLine());
    }
    
}
