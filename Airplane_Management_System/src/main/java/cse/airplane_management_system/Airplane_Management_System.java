package cse.airplane_management_system;

import cse.airplane_management_system.LoginSystem.LoginSystem;
import java.io.IOException;

/**
 * @author 박상현
 */
public class Airplane_Management_System {
    
    public LoginSystem loginSystem;
    /*
    public AirplaneSystem  airplaneSystem;
    public ReservaionSystem reservationSystem;
    public ReportSystem reportSystem;
    */
    
    public Airplane_Management_System(){};
    
    //각 시스템 객체 생성
    public void Init(){
        loginSystem = LoginSystem.GetSystem();
        /*
        airplaneSystem = new AiplaneSystem();
        reservationSystem = new ReservationSystem();
        reportSystem = new ReportSystem();
         */
    }
    
    //로그인 시스템 실행
    public void Run() throws IOException{
        loginSystem.Init();
        loginSystem.RunSystem();
    }
    
}
