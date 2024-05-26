package cse.airplane_management_system.ReservationSystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */
class ReservationDB implements ResObjectDB{
    
    private ArrayList<Reservation> ReservationDBList;
    private int dbSize;         //DB의 크기 
    
    //생성자
    public ReservationDB(){
        ReservationDBList = new ArrayList<>();
    }
    
    //배열에 저장
    public void AddRes(Reservation NewRes){
        ReservationDBList.add(NewRes);
    }
    
    //객체를 찾는 횟수??
    public int GetDBSize() {
        this.dbSize = ReservationDBList.size();
        return this.dbSize;
    }

    //DB에 있는 객체 찾아서 전달
    public Reservation GetReservation(int Index) {
        Reservation TargetRes = ReservationDBList.get(Index);
        return TargetRes;
    }

    public ArrayList<Reservation> GetReservationDB() {
        return ReservationDBList;
    }

    @Override
    public Iterator CreatIterator() {
        return  new ReservationDBIterator(this);
    }
 }
