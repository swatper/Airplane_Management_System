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
    private FileManager fileManager;
    private UserDB DB;
    public Iterator Iter;
    public static LoginSystem loginSystemObject; 
    
    //생성자(싱글톤 패턴)
    private LoginSystem(){};
    
    //객체 전달
   public static LoginSystem GetSystem(){
       if(loginSystemObject ==null){
           loginSystemObject = new LoginSystem();
       }
       return loginSystemObject;
   }
    
    //파일에 저장되어 있는 User정보String)로 User 객체 생성
    public void Init()throws IOException{
        DB = new UserDB();
        fileManager = new FileManager();    
        fileManager.createDBFile(0, "LoginSystem");
        ArrayList<String> readContext = fileManager.readDBFile(0);
        for(String temp : readContext){
            User tempUser = new User(temp.split(";")[0], temp.split(";")[1], temp.split(";")[2], Integer.parseInt(temp.split(";")[3]), 
                                                       temp.split(";")[4], temp.split(";")[5]);
            DB.AddUser(tempUser);
        }
    }
    //Swing으로 아이디 비번 입력받고 해당 값이 객체 배열에 있는지 확인
    public void RunSystem() throws IOException{
        System.out.print("아이디: ");
        BufferedReader GetID = new BufferedReader(new InputStreamReader(System.in));
        String ID = GetID.readLine();
        System.out.print("비밀번호: : ");
        BufferedReader GetPassword = new BufferedReader(new InputStreamReader(System.in));
        String PW = GetPassword.readLine();
        User loginUser = new User(ID, PW, "Test", 0,"Man" , "Homeless");
        if(FindUser(loginUser)){
            System.out.println("고객 있음");
        }
        else{
            System.out.println("고객 없어서 추가");
            AddUser(ID, PW, "Test", 0,"Man" , "Homeless");
        }
    }
    //DB로부터 고객 찾기
    public Boolean FindUser(User Target){
        Boolean isUserExist = false;
        //Iterator 객체 생성
        Iter = DB.CreatIterator();
         while(Iter.hasNext()){
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) Iter.next();
            System.out.println(temp.getUserID());
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if(Target.getUserID().equals(temp.getUserID())){
                isUserExist = true;
                break;
            }
         }
         return isUserExist;
    }
    
    //고객 추가
    public void AddUser(String id, String password, String name, int age, String gender, String address)throws IOException{
        User Temp = new User(id, password, name, age, gender, address);
        DB.AddUser(Temp);
        fileManager.writeDBFile(0, DB.GetUserDB());
    }
    
    //고객 정보 수정(이터레이터 패턴)
    public void ModifyUser(User modifyUser) throws IOException{
        //Iterator 객체 생성
        Iter = DB.CreatIterator();
        
        //수정할 회원 객체 찾기
        while(Iter.hasNext()){
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) Iter.next();
            System.out.println(temp.getUserID());
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if(temp.getUserID().equals(modifyUser.getUserID())){
                temp.SetName(modifyUser.getUserName());
                temp.SetAge(Integer.parseInt(modifyUser.getUserAge()));
                temp.SetAddress(modifyUser.getUserAddress());
                break;
            }
        }
        //변경사항 파일에 저장
        fileManager.writeDBFile(0, DB.GetUserDB());
    }
    
}
