package cse.airplane_management_system.AirPlaneSystem;

/**
 * @author 박상현
 */

public class AirPlane {
    private String Departures; //출발지
    private String Arrivals;      //도착지
    private String Types;         //국내선 국내선 구분
    private String Dates;        //날짜

    // 생성자
    public AirPlane(String Departure, String Arrival, String Type, String Date){
        this.Departures = Departure;
        this.Arrivals = Arrival;
        this.Types = Type;
        this.Dates = Date;
    }

    // getter 및 setter 메서드
    public String GetDepartures() {
        return Departures;
    }

    public void SetDepartures(String departure) {
        this.Departures = departure;
    }

    public String GetArrivals() {
        return Arrivals;
    }

    public void SetArrivals(String arrival) {
        this.Arrivals = arrival;
    }

    public String GetTypes() {
        return Types;
    }

    public void SetTypes(String type) {
        this.Types = type;
    }

    public String GetDates() {
        return Dates;
    }

    public void SetDates(String date) {
        this.Dates = date;
    }
}