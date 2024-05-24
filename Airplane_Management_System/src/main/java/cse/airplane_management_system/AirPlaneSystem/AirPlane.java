package cse.airplane_management_system.AirPlaneSystem;

import java.util.ArrayList;
/**
 * 항공편 클래스
 * @author 박상현
 */
public class AirPlane {
    private String Departures; // 출발지
    private String Arrivals;   // 도착지
    private String Types;      // 국내선/국제선 구분
    private String Dates;      // 날짜
    private int Price;         // 가격
    private String Name;       // 항공사명
    private ArrayList<Boolean> Seats; // 좌석 정보
    private int Totalprice; // 항공편 전체 가격 (좌석 수 * 항공편 가격)

    // 생성자
    public AirPlane(String departure, String arrival, String type, String date, int price, String name) {
        this.Departures = departure;
        this.Arrivals = arrival;
        this.Types = type;
        this.Dates = date;
        this.Price = price;
        this.Name = name;
        this.Seats = new ArrayList<>();
        initializeSeats(type);
        updateTotalPrice();
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
        initializeSeats(type);
        updateTotalPrice();
   }
        
    public String GetDates() {
        return Dates;
    }

    public void SetDates(String date) {
        this.Dates = date;
    }

    public double GetPrice() {
        return Price;
    }

    public void SetPrice(int price) {
        this.Price = price;
        updateTotalPrice();
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String name) {
        this.Name = name;   
    }
    
   public ArrayList<Boolean> GetSeats() {
        return Seats;
    }

    public void SetSeats(ArrayList<Boolean> seats) {
        this.Seats = seats;
        updateTotalPrice();
    }
    public int getTotalprice() {
        return Totalprice;
    }

    // 전체 가격 업데이트 메서드
    private void updateTotalPrice() {
        this.Totalprice = this.Price * this.Seats.size();
    }
    
     // 좌석 초기화 메서드
    private void initializeSeats(String type) {
        this.Seats.clear();
        int seatCount = type.equals("국내선") ? 20 : 50;
        for (int i = 0; i < seatCount; i++) {
            this.Seats.add(false);
        }
    }
}