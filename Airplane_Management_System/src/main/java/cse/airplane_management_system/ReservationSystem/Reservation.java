package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
public class Reservation {
    public String userID;
    public String airline;
    public String seatNum;
    
    public Reservation(String userID, String airline, String seatNum){
        this.userID = userID;
        this.airline = airline;
        this.seatNum = seatNum;
    }
    
    public String GetBookedUserID(){
        return userID;
    }
    
    public String GetBookedAirline(){
        return airline;
    }
    
    public String GetBookedSeatNum(){
        return seatNum;
    }
    
}
