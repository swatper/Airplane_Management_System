package cse.airplane_management_system.LoginSystem;

import cse.airplane_management_system.FileManager;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author 박상현
 */
public class LoginSystem extends JFrame{
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
      setTitle("로그인");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container swingContext = getContentPane();
        swingContext.setLayout(null);
        
        JLabel idLabel =new JLabel("ID : ");
        JLabel pswdLabel =new JLabel("Password : ");
        JTextField txtID = new JTextField();
        //로그인 버튼
        JPasswordField txtPass = new JPasswordField();
        JButton logBtn =new JButton("로그인");
        //회원 가입 버튼
        JPasswordField txtpass = new JPasswordField();
        JButton AddAccountBtn =new JButton("회원가입");
        
        idLabel.setBounds(30, 30,100,30);
        txtID.setBounds(120, 30,100,30);
        pswdLabel.setBounds(30, 60,100,30);
        txtPass.setBounds(120, 60,100,30);
        logBtn.setBounds(30, 100,100,30);
        txtpass.setBounds(120, 60,100,30);
        AddAccountBtn.setBounds(140, 100,100,30);
        
        swingContext.add(idLabel);
        swingContext.add(pswdLabel);
        swingContext.add(txtID);
        swingContext.add(txtPass);
        swingContext.add(logBtn);
         swingContext.add(txtpass);
        swingContext.add(AddAccountBtn);
        
        logBtn.addActionListener(event -> {
            User loginTryingUser;
            
            //아이디 입력
            String ID = txtID.getText();
            //비밀번호 입력
            String password = txtPass.getText();
            //비교를 위한 객체 생성
           loginTryingUser = new User(ID,password); 
            //비교
             if(FindUser(loginTryingUser)){
            System.out.println("고객 있음");
             }
             else{
            System.out.println("고객  없음");
            }
        });
        //회원 가입 버튼
       AddAccountBtn.addActionListener(event -> {
           
           //AddUser();
        });
       
        setVisible(true);
        setSize(280,180);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            if(Target.getUserID().equals(temp.getUserID()) && Target.getUserPassword().equals(temp.getUserPassword())){
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
