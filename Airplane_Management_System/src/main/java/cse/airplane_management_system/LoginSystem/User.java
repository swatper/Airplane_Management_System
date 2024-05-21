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
    private boolean isAdmin; //관리자

    //생성자
    public User(String id, String password, String name, int age, String gender, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.isAdmin = false;
    }

    //아이디 비번만 입력받는 생성자(사용자 입력이랑 DB에 있는 객체 비교용)
    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    //get함수들
    public String getUserID() {
        return id;
    }

    public String getUserPassword() {
        return password;
    }

    public String getUserName() {
        return name;
    }

    public String getUserGender() {
        return gender;
    }

    public String getUserAddress() {
        return address;
    }

    public String getUserAge() {
        String strAge = Integer.toString(age);
        return strAge;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    
    //User객체 속성값 수정
    public void SetName(String newName) {
        this.name = newName;
    }

    public void SetAge(int newAge) {
        this.age = newAge;
    }

    public void SetAddress(String newAddress) {
        this.address = newAddress;
    }
    
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    // 사용자 정보를 포맷팅하여 반환하는 메서드 추가
    public String getFormattedUserInfo() {
        return String.format("\n\n%s\n아이디 = %s ㅣ 패스워드 = %s ㅣ 나이 = %s ㅣ 성별 = %s ㅣ 주소 = %s", 
            name, id, password,gender, age, address);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userID='" + id + '\'' +
                ", userPassword='" + password + '\'' +
                ", userName='" + name + '\'' +
                ", userAge=" + gender +
                ", userGender='" + age + '\'' +
                ", userAddress='" + address + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
    
}
