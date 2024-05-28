package cse.airplane_management_system.ReservationSystem;

import java.util.Iterator;

/**
 * @author 박상현
 */
//Receiver
public class CommandResearcher {

    private String targetUserID;
    private String targetAirplaneDate;
    private ReservationDB db;
    private int Index;
    private int Type;
    //이터레이터 패턴
    private Iterator iter;

    //생성자
    public CommandResearcher(String UserID, ReservationDB DB, int Type) {
        this.targetUserID = UserID;
        this.db = DB;
        iter = db.CreatIterator();
        Index = 0;
        this.Type = Type;
        targetAirplaneDate = "5/30";
    }

    public void SetDate(String Date) {
        this.targetAirplaneDate = Date;
    }

    //예약 내역 조회 기능
    public void Search() {
        Boolean isExist = false;
        switch (Type) {
            case 1:
                while (iter.hasNext()) {
                    //특정 위치에 있는 객체 Iterato로 받기
                    Reservation temp = (Reservation) iter.next();
                    //로그인 유저의 ID와 예약 내역의 ID를 비교하여 찾기
                    if (targetUserID.equals(temp.GetBookedUserID())) {
                        isExist = true;
                        //항공편, 이름, 전화번호, 좌석 번호 출력
                        System.out.println("항공편: " + temp.GetBookedAirline() + "  "
                                + "날짜:" +temp.GetBookedAirlineDate() +" "
                                + "예약자: " + targetUserID + "  "
                                + "전화번호: " + temp.GetPhoneNumber() + "  "
                                + "좌석번호: " + temp.GetBookedSeatNum());
                    }
                }
                break;
            case 2:
                while (iter.hasNext()) {
                    //특정 위치에 있는 객체 Iterato로 받기
                    Reservation temp = (Reservation) iter.next();
                    //로그인 유저의 ID와 예약 내역의 ID, 날짜와 예약 내역의 날짜 비교
                    if (targetUserID.equals(temp.GetBookedUserID()) && targetAirplaneDate.equals(temp.GetBookedAirlineDate())) {
                        isExist = true;
                        break;
                    }
                    Index++;
                }
        }
        if (!isExist) {
            System.out.println("예약 내역이 없습니다. ");
        }
    }

    public int GetIndex() {
        return Index;
    }
}
