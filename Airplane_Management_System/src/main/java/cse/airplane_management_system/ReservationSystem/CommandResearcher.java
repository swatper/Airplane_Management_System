package cse.airplane_management_system.ReservationSystem;

import java.util.Iterator;

/**
 * @author 박상현
 */

//Receiver
public class CommandResearcher {
    private String targetUserID;
    private ReservationDB db;
    //이터레이터 패턴
    private Iterator iter;
    
    //생성자
    public CommandResearcher(String UserID, ReservationDB DB){
        this.targetUserID = UserID;
        this.db = DB;
        iter = db.CreatIterator();
        
    
    };
    
    //예약 내역 조회 기능
    public void Search() {
        Boolean isExist = false;
        while (iter.hasNext()) {
            //특정 위치에 있는 객체 Iterato로 받기
            Reservation temp = (Reservation) iter.next();
            //로그인 유저의 ID와 예약 내역의 ID를 비교하여 찾기
            if (targetUserID.equals(temp.GetBookedUserID())) {
                isExist = true;
                //항공편, 이름, 전화번호, 좌석 번호 출력
                System.out.println("항곤편: "+temp.GetBookedAirline() +"  "+
                        "예약자: "+targetUserID +"  "+
                        "전화번호: "+temp.GetPhoneNumber() +"  "+ 
                        "좌석번호: "+temp.GetBookedSeatNum());
            }
        }
        if(!isExist){
            System.out.println("예약 내역이 없습니다. ");
        }
    }
}
