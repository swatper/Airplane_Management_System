/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.LoginSystem;

/**
 *
 * @author 박상현
 */
public class User {
    private String id;             //아이디
    private String password;//비밀번호
    private String name;       //이름
     private int age;            //나이
    private String gender;    //성별
    private String address;  //주소
    
    //생성자
    public User(String id, String password, String name, int age, String gender, String address){
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    //get함수들
    public String getUserID(){
        return id;
    }
    
    public String getUserPassword(){
        return password;
    }
    
    public String getUserName(){
        return name;
    }
    
    public String getUserGender(){
        return gender;
    }
    
    public String getUserAddress(){
        return address;
    }
    
    public String getUserAge(){
        String strAge = Integer.toString(age);
        return strAge;
    }
    
    //User객체 속성값 수정
    public void  SetName(String newName){
    this.name = newName;
    }
    
    public void SetAge(int newAge){
        this.age = newAge;
    }
    
    public void SetAddress(String newAddress){
     this.address = newAddress;
    }
    
}
