package cse.airplane_management_system.LoginSystem;

import cse.airplane_management_system.FileManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */
public class LoginSystem {

    public User LoginUser;  //현재 로그인중인 유저를 저장할 변수
    private FileManager fileManager;
    private UserDB DB;
    public Iterator Iter;
    public static LoginSystem loginSystemObject;

    //생성자(싱글톤 패턴)
    private LoginSystem() {
    }

    //객체 전달
    public static LoginSystem GetSystem() {
        if (loginSystemObject == null) {
            loginSystemObject = new LoginSystem();
        }
        return loginSystemObject;
    }

    //파일에 저장되어 있는 User정보String)로 User 객체 생성(시스템 초기화 작업)
    public void Init() throws IOException {
        LoginUser = null;
        DB = new UserDB();
        fileManager = new FileManager();
        fileManager.createDBFile(0, "LoginSystem");
        ArrayList<String> readContext = fileManager.readDBFile(0);
        for (String temp : readContext) {
            User tempUser = new User(temp.split(";")[0], temp.split(";")[1], temp.split(";")[2], Integer.parseInt(temp.split(";")[3]),
                    temp.split(";")[4], temp.split(";")[5]);
            DB.AddUser(tempUser);
        }
    }

    //Swing으로 아이디 비번 입력받고 해당 값이 객체 배열에 있는지 확인 (스윙쓰면 이 부분 불필요)
    public void RunSystem() throws IOException {
        while (LoginUser == null) {
            System.out.println("======================================");
            System.out.println("원하는 메뉴를 선택하세요: 1.로그인  2. 회원가입");
            BufferedReader GetMenu = new BufferedReader(new InputStreamReader(System.in));
            int MenuMode = Integer.parseInt(GetMenu.readLine());

            switch (MenuMode) {
                //로그인 메서드 호출
                case 1:
                    Login();
                    break;
                //회원가입 메서드 호출
                case 2:
                    AddAccount();
                    break;
            }
        }
    }

    //로그인 기능 (스윙 필요)
    public void Login() throws IOException {
        System.out.println("======================================");
        System.out.print("아이디: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String ID = GetID.readLine();
        System.out.print("비밀번호: ");
        BufferedReader GetPassword = new BufferedReader(new InputStreamReader(System.in));
        String PW = GetPassword.readLine();
        User loginUser = new User(ID, PW);

        //입력한 정보가 로그인 DB에 있는지 확인
        if (FindUser(loginUser)) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("고객 정보 없음");
        }
    }

    //회원가입 기능(스윙 필요)
    public void AddAccount() throws IOException {
        System.out.println("======================================");
        System.out.print("아이디: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String ID = GetID.readLine();
        System.out.print("비밀번호: ");
        BufferedReader GetPassword = new BufferedReader(new InputStreamReader(System.in));
        String PW = GetPassword.readLine();
        System.out.print("이름: ");
        BufferedReader GetName = new BufferedReader(new InputStreamReader(System.in));
        String Name = GetName.readLine();
        System.out.print("나이: ");
        BufferedReader GetAge = new BufferedReader(new InputStreamReader(System.in));
        int Age = Integer.parseInt(GetAge.readLine());
        System.out.print("성별: ");
        BufferedReader GetGenger = new BufferedReader(new InputStreamReader(System.in));
        String Gender = GetGenger.readLine();
        System.out.print("주소: ");
        BufferedReader GetAddress = new BufferedReader(new InputStreamReader(System.in));
        String Address = GetAddress.readLine();
        //저장
        AddUser(ID, PW, Name, Age, Gender, Address);
        System.out.println("회원가입 성공!!");
    }

    //DB로부터 고객 찾기
    public Boolean FindUser(User Target) {
        Boolean isUserExist = false;
        //Iterator 객체 생성
        Iter = DB.CreatIterator();
        while (Iter.hasNext()) {
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) Iter.next();
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if (Target.getUserID().equals(temp.getUserID()) && Target.getUserPassword().equals(temp.getUserPassword())) {
                isUserExist = true;
                //로그인 유저 저장
                LoginUser = temp;
                break;
            }
        }
        return isUserExist;
    }

    //고객 추가
    public void AddUser(String id, String password, String name, int age, String gender, String address) throws IOException {
        User Temp = new User(id, password, name, age, gender, address);
        DB.AddUser(Temp);
        fileManager.writeDBFile(0, DB.GetUserDB());
    }

    //고객 정보 수정(이터레이터 패턴)
    public void ModifyUser(User modifyUser) throws IOException {
        //Iterator 객체 생성
        Iter = DB.CreatIterator();

        //수정할 회원 객체 찾기
        while (Iter.hasNext()) {
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) Iter.next();
            System.out.println(temp.getUserID());
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if (temp.getUserID().equals(modifyUser.getUserID())) {
                //이름, 나이, 주소 수정
                temp.SetName(modifyUser.getUserName());
                temp.SetAge(Integer.parseInt(modifyUser.getUserAge()));
                temp.SetAddress(modifyUser.getUserAddress());
                break;
            }
        }
        //변경사항 파일에 저장
        fileManager.writeDBFile(0, DB.GetUserDB());
    }

    //로그인 유저를 메인 시스템에 전달
    public User GetLoginUser() {
        return LoginUser;
    }

}
