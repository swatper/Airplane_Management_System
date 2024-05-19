package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.FileManager;
import cse.airplane_management_system.LoginSystem.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */

//Command Pattern Client
public class ReservationSystem {
    public User loginUser;
    public String airlineName;
    //public Airplane ReservAirplane;
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
    private ReservationSystem(User LoginUser){
        this.loginUser = LoginUser;
    }
    
   public static ReservationSystem GetSystem(User LoginUser){
       if(reservationSystem == null){
           reservationSystem = new ReservationSystem(LoginUser);
       }
       return reservationSystem;
   }
   
    //시스템 초기화 작업
    public void Init() throws IOException{
        DB = new ReservationDB();
        //리모컨 객체 생성
        Controller = new CommandController();
        
        fileManager = new FileManager();
        fileManager.createDBFile(2, "ReservationSystem");
        
        //파일에 있는 내용으로 객체 만들기
        ArrayList<String> readContext = fileManager.readDBFile(2);
         for (String temp : readContext) {
             Reservation tempRes = new Reservation(temp.split(";")[0],temp.split(";")[1],temp.split(";")[2],
                     temp.split(";")[3], temp.split(";")[4]);
            DB.AddRes(tempRes);
        }
    }
    
    //시스템 시작(메인 메뉴)
    public void RunSystem() throws IOException{
        System.out.println("=====================================");
        System.out.println("원하시는 메뉴를 선택하세요: 1 예약조회 2. 항공편 예약");
        BufferedReader getMenuMode = new BufferedReader(new InputStreamReader(System.in));
        int menuMode = Integer.parseInt(getMenuMode.readLine());
        switch (menuMode) {
            case 1:
                //유저의 예약 조회 함수 호출
                Lookup();
                break;
            case 2:
                //항공편 예약(항공편, 자리) 함수 호출
                Reservate();
                break;
            default:
                System.out.println("옳바른 메뉴를 선택해주세요. ");
                break;
        }
    }
    
    //로그인 고객의 이름을 이용해서 예약 내역 조회
    public void Lookup(){
        //------------------------Command 패턴 사용
        Researcher = new CommandResearcher(loginUser.getUserID(), DB);
        ResearchCommand = new CommandResearch(Researcher);
        Controller.SetCommand(ResearchCommand);
        Controller.RunCommand();
    }
    
    //예약 하기
    public void Reservate() throws IOException{
        System.out.println("원하시는 항공사를 선택해주세요: 1. 대한항공 2. 아시아나항공 3. 부산에어 ");
        BufferedReader getAirline = new BufferedReader(new InputStreamReader(System.in));
        int AirlineNum = Integer.parseInt(getAirline.readLine());
        //비행기 객체의 속성 값을 가져올 예정
        switch (AirlineNum) {
            case 1:
                airlineName = "KorAir";
                break;
            case 2:
                airlineName = "AsiAir";
                break;
            case 3:
                airlineName = "BusAir";
                break;
            default:
                System.out.println("옳바른 메뉴를 선택해주세요. ");
                break;
        }
        SelectSeat();
    }
    
    
    //예약 내역 추가
    public void SelectSeat() throws IOException{
        System.out.print("원하시는 좌석을 선태해주세요.(1~20): ");
        BufferedReader getSeatNum = new BufferedReader(new InputStreamReader(System.in));
        String SeatNum = getSeatNum.readLine();
        System.out.print("전화번호를 입력해주세요: ");
        BufferedReader getPhoneNum = new BufferedReader(new InputStreamReader(System.in));
        String PhoneNum = getPhoneNum.readLine();
        //파일에 저장
        AddReservation(PhoneNum, SeatNum);
        System.out.println("예약 완료 ");
    }
    
    //예약 내역 파일에 추가
    public void AddReservation(String PhoneNum, String SeatNum){
        Reservation NewRes = new Reservation(airlineName, loginUser.getUserID(), loginUser.getUserName(), PhoneNum, SeatNum);
        //DB에 추가
        DB.AddRes(NewRes);
        
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
