package cse.airplane_management_system.ReservationSystem;

import java.util.Iterator;

/**
 * @author 박상현
 */
public class ReservationDBIterator implements Iterator<Reservation>{
    private ReservationDB ResDB;
    private int ResIndex = 0;
    
    //생성자
    public ReservationDBIterator(ReservationDB DB){
        this.ResDB = DB;
    }

    @Override
    public boolean hasNext() {    
        return ResIndex < ResDB.GetDBSize();
    }

    @Override
    public Reservation next() {
        Reservation targetRes = ResDB.GetReservation(ResIndex);
        ResIndex++;
        return targetRes;
    }
    
}
