package cse.airplane_management_system.AirPlaneSystem;

/**
 * @author 박상현
 */

public class AirPlane {
    private String Departures; //출발지
    private String Arrivals;      //도착지
    private String Types;         //항공사
    private String Dates;        //날짜
    private boolean isDomestic; //국내선 국제선 여부

    // 생성자
    public AirPlane(String Departure, String Arrival, String Type, String Date, boolean isDomestic){
        this.Departures = Departure;
        this.Arrivals = Arrival;
        this.Types = Type;
        this.Dates = Date;
        this.isDomestic = isDomestic;
    }

    // getter 및 setter 메서드
    public String getDepartures() {
        return Departures;
    }

    public void setDepartures(String departure) {
        this.Departures = departure;
    }

    public String getArrivals() {
        return Arrivals;
    }

    public void setArrivals(String arrival) {
        this.Arrivals = arrival;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String type) {
        this.Types = type;
    }

    public String getDates() {
        return Dates;
    }

    public void setDates(String date) {
        this.Dates = date;
    }
     public boolean isDomestic() {
        return isDomestic;
    }
}