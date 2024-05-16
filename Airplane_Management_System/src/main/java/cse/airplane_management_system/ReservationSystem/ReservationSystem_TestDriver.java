package cse.airplane_management_system.ReservationSystem;

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
        ReservationSystem ReSystem = ReservationSystem.GetSystem(LoginUser);
        ReSystem.Init(LoginUser);
        ReSystem.RunSystem();
    }
}