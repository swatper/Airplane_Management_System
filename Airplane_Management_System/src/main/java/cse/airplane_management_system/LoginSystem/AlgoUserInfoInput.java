package cse.airplane_management_system.LoginSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 박상현
 */

//사용자의 ID와 비밀 번호를 받는 메서드를 추상화
public abstract class AlgoUserInfoInput {
    public String userID;
    public String userPW;
    public User TargetUser;
    
    //알고리즘(?)
    final User GetUserInput() throws IOException{
        IDInput();
        PWInput();
        OtherInfoInput();
        return TargetUser;
    }
    //아이디 입력 받는 메서드
    public void IDInput() throws IOException{
        System.out.println("======================================");
        System.out.print("아이디: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String ID = GetID.readLine();
        userID = ID;
    }
    
    //비밀번호 입력 받는 메서드
    public void PWInput() throws IOException{
        System.out.print("비밀번호: ");
        BufferedReader GetPassword = new BufferedReader(new InputStreamReader(System.in));
        String PW = GetPassword.readLine();
        userPW = PW;
    }
    
    //추가 정보 입력 받고 TargetUser객체 만드는 메서드
    abstract  void OtherInfoInput();
    
    
}
