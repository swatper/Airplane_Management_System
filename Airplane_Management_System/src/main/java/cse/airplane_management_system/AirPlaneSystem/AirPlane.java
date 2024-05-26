package cse.airplane_management_system.AirPlaneSystem;

import java.util.ArrayList;

/**
 * 항공편 클래스
 * @author 박상현
 */
public class AirPlane {
    private String Departures; // 출발지
    private String Arrivals;   // 도착지
    private String Airlines;    // 항공사명 
    private String Dates;      // 날짜
    private boolean isDomestic; // 국내선 국제선 여부
    private int Price;         // 가격
    private ArrayList<Boolean> Seats; // 좌석 정보
    private int Totalprice;    // 항공편 전체 가격 (예약된 좌석 수 * 항공편 가격)
    

    // 생성자
    public AirPlane(String departure, String arrival, String airline, String date, boolean isDomestic, int price) {
        this.Departures = departure;
        this.Arrivals = arrival;
        this.isDomestic = isDomestic;
        this.Dates = date;
        this.Price = price;
        this.Airlines = airline;
        this.Seats = new ArrayList<>();
        initializeSeats();
        updateTotalPrice();
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

    public String getDates() {
        return Dates;
    }

    public void setDates(String date) {
        this.Dates = date;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
        updateTotalPrice();
    }

    public String getAirlines() {
        return Airlines;
    }

    public void setAirlines(String airline) {
        this.Airlines = airline;
    }

    public ArrayList<Boolean> getSeats() {
        return Seats;
    }

    public void setSeats(ArrayList<Boolean> seats) {
        this.Seats = seats;
        updateTotalPrice();
    }

    public int getTotalprice() {
        return Totalprice;
    }
    
    public boolean isDomestic() {
    return isDomestic;
}

    // 전체 가격 업데이트 메서드
    private void updateTotalPrice() {
        int reservedSeats = 0;
        for (Boolean seat : Seats) {
            if (seat) {
                reservedSeats++;
            }
        }
        this.Totalprice = this.Price * reservedSeats; // 항공편 가격 * 예약된 좌석 수
    }

    // 좌석 초기화 메서드
    private void initializeSeats() {
        this.Seats.clear();
        int seatCount = isDomestic ? 20 : 50;
        for (int i = 0; i < seatCount; i++) {
            this.Seats.add(false);
        }
    }
}