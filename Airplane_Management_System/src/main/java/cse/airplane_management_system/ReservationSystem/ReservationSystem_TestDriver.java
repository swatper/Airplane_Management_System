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
        User LoginUser = new User("Admin", "1234");
        ReservationSystem ReSystem = ReservationSystem.reservationSystem();
        ReSystem.Init(LoginUser);
        ReSystem.RunSystem();
        
    }
    
}
