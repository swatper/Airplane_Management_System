package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
public class Reservation {
    
    public String airline;
    public String userID;
    public String userName;
    public String userPhoneNum;
    public String seatNum;
    
    public Reservation(String airline, String userID,String userName, String PhoneNum, String seatNum){
        this.airline = airline;
        this.userID = userID;
        this.userName = userName;
        this.userPhoneNum = PhoneNum;
        this.seatNum = seatNum;
    }
    
    public String GetBookedAirline(){
        return airline;
    }
    
    public String GetBookedUserID(){
        return userID;
    }
    
    public String GetBookedUserName(){
        return userName;
    }
    
    public String GetPhoneNumber(){
        return userPhoneNum;
    }
    
    public String GetBookedSeatNum(){
        return seatNum;
    }
    
}
