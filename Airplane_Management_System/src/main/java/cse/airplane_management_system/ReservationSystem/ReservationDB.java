package cse.airplane_management_system.ReservationSystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */
public class ReservationDB implements ObjectDB{
    private ArrayList<Reservation> ResDB;
    private int dbSize;         //DB의 크기 
    
    public ReservationDB(){
        ResDB = new ArrayList<>();
    }
    //객체를 찾는 횟수??
    public int GetDBSize() {
        this.dbSize = ResDB.size();
        return this.dbSize;
    }

    //DB에 있는 객체 찾아서 전달
    public Reservation GetUser(int Index) {
        Reservation TargetUser = ResDB.get(Index);
        return TargetUser;
    }

    public ArrayList<Reservation> GetUserDB() {
        return ResDB;
    }

    @Override
    public Iterator CreatIterator() {
        return  new ReservationDBIterator(this);
    }

 }
