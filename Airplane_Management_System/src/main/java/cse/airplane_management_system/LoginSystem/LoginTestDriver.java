package cse.airplane_management_system.LoginSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * @author 박상현
 */
public class LoginTestDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         UserDB DB = new UserDB();
        boolean isUserExist = false;
        //객체 생성
        User A = new User("A", "B", "Name", 0, "Man" ,"Address");
        User B = new User("1", "2", "Name", 0, "Man" ,"Address");
        User C = new User("?", "!", "Name", 0, "Man" ,"Address");
        //객체 추가
        DB.AddUser(A);
        DB.AddUser(B);
        DB.AddUser(C);
        //Iterator 생성
        Iterator It = DB.CreatIterator();
        
        System.out.print("찾을 유저 ID: ");
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String TargetUserID ;
        TargetUserID = is.readLine();
        
        //Iterator을 이용하여 객체 전체 탐색
        while(It.hasNext()){
            //특정 위치에 있는 객체 Iterato로 받기
            User temp = (User) It.next();
            System.out.println(temp.getUserID());
            //앞에서 받은 User 객체의 ID가 찾으려는 ID와 같은지 확인
            if(temp.getUserID().equals(TargetUserID)){
                isUserExist = true;
                break;
            }
        }
        //유저 유무 확인
        if(isUserExist){
            System.out.println("유저 있음");
            
        }
        else{
            System.out.println("유저 없음");
        }
    }
    
}
