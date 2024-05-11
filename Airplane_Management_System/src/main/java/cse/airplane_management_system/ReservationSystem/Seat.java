package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
public class Seat {
    public int seatNum;             //좌석 번호
    public int seatPrice;           //좌석 가격
    public String UserName;
    public Boolean isBooked; //좌석 예약 여부
    
    //생성자(예약된 좌석만 DB에 저장할 예정)
    public Seat(int Num, int Price){
        this.seatNum = Num;
        this.seatPrice = Price;
        isBooked = false;
    }
    
    
    public void SetSeatStatus(){
        isBooked = true;
    }
    
    public int GetSeatNum(){
        return seatNum;
    }
    
    public int GetSeatPrice(){
        return seatPrice;
    }
    
    public String GetUserName(){
        return UserName;
    }
    
    public Boolean GetSeatStatus(){
        return isBooked;
    }
    
    
}
