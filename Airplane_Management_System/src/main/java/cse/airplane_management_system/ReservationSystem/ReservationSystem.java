package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import cse.airplane_management_system.FileManager;
import cse.airplane_management_system.LoginSystem.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author 박상현
 */
//Command Pattern Client
public class ReservationSystem {
    public User loginUser;
    public AirPlane ReservAirplane;
    public int targerAirlineIndex = 0;
    public FileManager fileManager;
    public static ReservationSystem reservationSystem;
    public ReservationDB DB;
    //------------Command 패턴 객체
    //기능(버튼의 기능)
    public CommandWriter Writer;                  //파일 쓰기
    public CommandResearcher Researcher;//예약 조회
    //버튼
    public CommandWrite WriteCommand;
    public CommandResearch ResearchCommand;
    //Command 패턴의 리모컨 
    public CommandController Controller;
    //생성자(싱글턴 패턴)
    private ReservationSystem(User LoginUser) {
        this.loginUser = LoginUser;
    }
    public static ReservationSystem GetSystem(User LoginUser) {
        if (reservationSystem == null) {
            reservationSystem = new ReservationSystem(LoginUser);
        }
        return reservationSystem;
    }
    //DB정보 가져오기(보고서 시스템에서 예약 현황 확인할 때 사용할 객체 배열)
    public ReservationDB GetReservationDB() {
        return DB;
    }
    //시스템 초기화 작업
    public void Init() throws IOException {
        DB = new ReservationDB();
        //리모컨 객체 생성
        Controller = new CommandController();
        fileManager = new FileManager();
        fileManager.createDBFile(2, "ReservationSystem");
        //파일에 있는 내용으로 객체 만들기
        ArrayList<String> readContext = fileManager.readDBFile(2);
        for (String temp : readContext) {
            Reservation tempRes = new Reservation(temp.split(";")[0], temp.split(";")[1], temp.split(";")[2],
                    temp.split(";")[3], temp.split(";")[4], temp.split(";")[5]);
            DB.AddRes(tempRes);
        }
    }
    //시스템 시작(메인 메뉴)
    public void RunSystem(AirPlane TargetAirPlane) throws IOException {
        ReservAirplane = TargetAirPlane;
        System.out.println("=====================================");
        while (true) {
            System.out.println("원하시는 메뉴를 선택하세요: 1. 항공편 예약 2. 예약 조회 3. 예약 취소 4. 뒤로가기");
            BufferedReader getMenuMode = new BufferedReader(new InputStreamReader(System.in));
            int menuMode = Integer.parseInt(getMenuMode.readLine());
            switch (menuMode) {
                case 1:
                    //항공편 예약(항공편, 자리) 함수 호출
                    Reservate();
                    break;
                case 2:
                    //예약 조회 함수 호출
                    Lookup(1,ReservAirplane );
                    break;
                case 3:
                    //예약 취소 함수 호출
                    CancelReservation();
                    break;
                case 4:
                    //예약 시스템 종료
                    return;
                default:
                    System.out.println("옳바른 메뉴를 선택해주세요. ");
                    break;
            }
        }
    }
    //예약 하기(항공기 객체 배열 받아와서 항공기 객체 선택하기)
    public void Reservate() throws IOException {
        SelectSeat();
    }
    //예약 내역 추가(항공기 객체 받아와서 항공기 객체 정보 사용)
    public void SelectSeat() throws IOException {
        while (true) {
            System.out.print("원하시는 좌석을 선태해주세요.(1~20): ");
            BufferedReader getSeatNum = new BufferedReader(new InputStreamReader(System.in));
            String SeatNum = getSeatNum.readLine();
            System.out.print("전화번호를 입력해주세요: ");
            BufferedReader getPhoneNum = new BufferedReader(new InputStreamReader(System.in));
            String PhoneNum = getPhoneNum.readLine();
            
            ArrayList<Boolean> TempSeat = ReservAirplane.getSeats();
            //이미 좌석이 예약된 상태면
            Boolean Temp = true;
            if (TempSeat.get(targerAirlineIndex) == Temp) {
                System.out.println(TempSeat.get(targerAirlineIndex));
                //예약 불가
                System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
            } else {
                TempSeat.set(targerAirlineIndex, true);
                
                //매출 증가
                if(Integer.parseInt(SeatNum) < 5){
                    ReservAirplane.AddTotalPrice(100000);
                }
                else{
                     ReservAirplane.AddTotalPrice(70000);
                }
                //System.out.println(ReservAirplane.getTotalprice());
                //파일에 저장
                AddReservation(PhoneNum, SeatNum);
                System.out.println("예약 완료 ");
                break;
            }
        }
    }
    //예약 내역 파일에 추가
    public void AddReservation(String PhoneNum, String SeatNum) {
        Reservation NewRes = new Reservation(ReservAirplane.getAirlines(), ReservAirplane.getDates(), loginUser.getUserID(), loginUser.getUserName(), PhoneNum, SeatNum);
        //System.out.println(ReservAirplane.getDates());
        //DB에 추가
        DB.AddRes(NewRes);
        //파일에 적기
        WriteFile();
    }
    //예약 취소 메서드
    public void CancelReservation() throws IOException {
        System.out.print("취소하려는 항공편을 입력해주세요: ");
        BufferedReader getAirline = new BufferedReader(new InputStreamReader(System.in));
        String airline = getAirline.readLine();
        System.out.print("항공편의 날짜를 입력해주세요: ");
        BufferedReader getDate = new BufferedReader(new InputStreamReader(System.in));
        String date = getDate.readLine();
        AirPlane temp = new AirPlane(airline, date);
        //항공편 찾기
        Lookup(2, temp);
        //해당 항공편 삭제하기
        DB.DeleteReservation(targerAirlineIndex);
        //파일에 적기
        WriteFile();
    }
     //로그인 고객의 이름을 이용해서 예약 내역 조회
    public void Lookup(int Type, AirPlane targetAirplane) {
        //------------------------Command 패턴 사용
        Researcher = new CommandResearcher(loginUser.getUserID(), DB, Type);
        Researcher.SetDate(targetAirplane.getDates());
        ResearchCommand = new CommandResearch(Researcher);
        Controller.SetCommand(ResearchCommand);
        Controller.RunCommand();
        targerAirlineIndex = Researcher.GetIndex();
    }
    //객체 배열 받아서 파일에 적는 메서드
    public void WriteFile() {
        //------------------------Command 패턴 사용
        //파일 쓰는 기능 생성
        Writer = new CommandWriter(DB);
        //버튼 생성
        WriteCommand = new CommandWrite(Writer);
        //리모컨에 버튼 추가
        Controller.SetCommand(WriteCommand);
        //버튼 누르기(파일 쓰기)
        Controller.RunCommand();
    }
}
