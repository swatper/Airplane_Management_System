package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import cse.airplane_management_system.LoginSystem.User;
import java.io.IOException;

/**
 * @author 박상현
 */
public class ReservationSystem_TestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //관리자로 로그인
        User LoginUser = new User("Admin", "1234", "실험",10 ,"Test", "?");
        AirPlane ResAirPlane = new AirPlane("서울", "부산", "국내선", "5/30");
        ReservationSystem ReSystem = ReservationSystem.GetSystem(LoginUser);
        ReSystem.Init();
        ReSystem.RunSystem();
    }
}