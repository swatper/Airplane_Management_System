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
    public int targetUserIndex; //Iterator의 반복 횟수를 이용하여 DB의 사용자 Index를 얻을 변수
    //템플릿 메서드 패턴의 객체
    public AlgoLogin login;
    public AlgoAddAccount addAccount;

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
        //템플릿 메서드 패턴 객체 생성
        login = new AlgoLogin();
        addAccount = new AlgoAddAccount();
    }

    //Swing으로 아이디 비번 입력받고 해당 값이 객체 배열에 있는지 확인 (스윙쓰면 이 부분 불필요)
    public void RunSystem() throws IOException {
        while (LoginUser == null) {
            System.out.println("======================================");
            System.out.println("원하는 메뉴를 선택하세요: 1.로그인  2. 회원가입 3. 고객정보 수정 및 삭제");
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
                case 3:
                    ModifyOrDeleteUserInfo();
                    break;
            }
        }
    }

    //로그인 기능 (스윙 필요)
    public void Login() throws IOException {
        //템플릿 메서드 객체 사용
        User loginUser = login.GetUserInput();

        //입력한 정보가 로그인 DB에 있는지 확인
        if (FindUser(loginUser)) {
            if ("Admin".equals(loginUser.getUserID())) {
                LoginUser.setAdmin(true);
                System.out.println("관리자 로그인 성공");
            } else {
                System.out.println("로그인 성공");
            }
        } else {
            System.out.println("고객 정보 없음");
        }
    }

    //회원가입 기능(스윙 필요)
    public void AddAccount() throws IOException {
        
        //템플릿 메서드 패턴 객체 생성 및 배열에 추가
        DB.AddUser(addAccount.GetUserInput());
        // 파일에 저장
        fileManager.writeDBFile(0, DB.GetUserDB());
        
        System.out.println("회원가입 성공!!");
    }
    
    // 새로운 메서드 추가: 고객 정보 수정 및 삭제 메뉴
    public void ModifyOrDeleteUserInfo() throws IOException {
        System.out.println("======================================");
        System.out.println("원하는 작업을 선택하세요: 1.고객 정보 수정  2.고객 정보 삭제 3. 고객 정보 조회");
        BufferedReader GetMenu = new BufferedReader(new InputStreamReader(System.in));
        int MenuMode = Integer.parseInt(GetMenu.readLine());

        switch (MenuMode) {
            case 1:
                // 고객 정보 수정 메서드 호출
                ModifyUserInfo();
                break;
            case 2:
                // 고객 정보 삭제 메서드 호출
                DeleteUserInfo();
                break;
            case 3:
                // 고객 정보 조회 메서드 호출
               System.out.println("관리자 로그인이 필요합니다.");
                Login();
                if (LoginUser != null && LoginUser.isAdmin()) {
                    System.out.println("관리자 로그인 성공");
                    ViewUserInfo();
                } else {
                    System.out.println("관리자 권한이 없습니다.");
                }
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                break;
    }
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
    
    // 고객 정보 삭제 메서드
    /*public void DeleteUser(User deleteUser) {
        userDBList.remove(deleteUser);
    }*/

    //고객 정보 수정(이터레이터 패턴)
    public void ModifyUser(String userId, User modifyUser) throws IOException {
        //Iterator 객체 생성
        Iter = DB.CreatIterator();

        //수정할 회원 객체 찾기
        while (Iter.hasNext()) {
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) Iter.next();
            System.out.println(temp.getUserID());
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if (temp.getUserID().equals(userId)) {
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
    
    // 고객 정보 수정 메서드
    public void ModifyUserInfo() throws IOException {
        System.out.println("======================================");
        System.out.print("수정할 고객의 아이디를 입력하세요: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String userID = GetID.readLine();
    
        // 해당 아이디를 가진 고객 정보 객체 찾기
        User modifyUser = FindUserByID(userID);
    
        if (modifyUser != null) { // 수정할 고객 정보가 존재하는 경우
            System.out.println("수정할 정보를 입력하세요:");
            // 새로운 정보 입력
            System.out.print("이름: ");
            BufferedReader GetName = new BufferedReader(new InputStreamReader(System.in));
            String newName = GetName.readLine();
            System.out.print("나이: ");
            BufferedReader GetAge = new BufferedReader(new InputStreamReader(System.in));
            int newAge = Integer.parseInt(GetAge.readLine());
            System.out.print("주소: ");
            BufferedReader GetAddress = new BufferedReader(new InputStreamReader(System.in));
            String newAddress = GetAddress.readLine();

            // 수정할 정보를 새로운 값으로 업데이트
            modifyUser.SetName(newName);
            modifyUser.SetAge(newAge);
            modifyUser.SetAddress(newAddress);

            // 파일에 변경사항 저장
            fileManager.writeDBFile(0, DB.GetUserDB());
            System.out.println("고객 정보가 성공적으로 수정되었습니다.");
            }
            else { // 수정할 고객 정보가 존재하지 않는 경우
            System.out.println("해당 아이디를 가진 고객 정보가 없습니다.");
        }
    }
    
    // 고객 정보 삭제 메서드
    public void DeleteUserInfo() throws IOException {
        System.out.println("======================================");
        System.out.print("삭제할 고객의 아이디를 입력하세요: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String userID = GetID.readLine();

        // 해당 아이디를 가진 고객 정보 객체 찾기
        User deleteUser = FindUserByID(userID);

        if (deleteUser != null) { // 삭제할 고객 정보가 존재하는 경우
            // 고객 정보 삭제
            DB.DeleteUser(targetUserIndex);
            
            // 파일에 변경사항 저장
            fileManager.writeDBFile(0, DB.GetUserDB());
            System.out.println("고객 정보가 성공적으로 삭제되었습니다.");
            } 
            else { // 삭제할 고객 정보가 존재하지 않는 경우
            System.out.println("해당 아이디를 가진 고객 정보가 없습니다.");
        }
    }
        // 아이디를 이용하여 해당 고객 정보를 찾는 메서드
    public User FindUserByID(String userID) {
        targetUserIndex = 0;
        Iter = DB.CreatIterator();
        while (Iter.hasNext()) {
            User temp = (User) Iter.next();
            if (temp.getUserID().equals(userID)) {
                return temp;
            }
            targetUserIndex++;
        }
        return null;
    }   
    // 모든 고객 정보 조회 메서드 (관리자 전용)
    public void ViewUserInfo() throws IOException {
        System.out.println("======================================");
        System.out.print("모든 고객 정보: ");
        Iter = DB.CreatIterator();
        while (Iter.hasNext()) {
            User user = (User) Iter.next();
            System.out.println(user.getFormattedUserInfo());
        }
    }
    
    //로그인 유저를 메인 시스템에 전달
    public User GetLoginUser() {
        return LoginUser;
    }

}
