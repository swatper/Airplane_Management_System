package cse.airplane_management_system;

import cse.airplane_management_system.AirPlaneSystem.AirPlaneSystem;
import cse.airplane_management_system.LoginSystem.LoginSystem;
import cse.airplane_management_system.LoginSystem.User;
import java.io.IOException;

/**
 * @author 박상현
 */
public class Airplane_Management_System {

    public User LoginUser;
    public LoginSystem loginSystem;
    public AirPlaneSystem airPlaneSystem;

    /*
    public AirplaneSystem  airplaneSystem;
    public ReservaionSystem reservationSystem;
    public ReportSystem reportSystem;
     */

    public Airplane_Management_System() {
    }

    ;
    
    //각 시스템 객체 생성
    public void Init() throws IOException {
        loginSystem = LoginSystem.GetSystem();
        airPlaneSystem = new AirPlaneSystem();
        
        /*
        reportSystem = new ReportSystem();
         */
    }

    //로그인 시스템 실행
    public void RunLogin() throws IOException {
        //로그인 시스템
        loginSystem.Init();
        loginSystem.RunSystem();
        LoginUser = loginSystem.GetLoginUser();
        
        //비행기 관리 시스템
        airPlaneSystem.RunSystem(LoginUser);
        
    }
}
