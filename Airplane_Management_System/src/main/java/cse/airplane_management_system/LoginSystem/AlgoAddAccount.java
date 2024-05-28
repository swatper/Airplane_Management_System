/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.LoginSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 박상현
 */
public class AlgoAddAccount extends AlgoUserInfoInput{

    @Override
    void OtherInfoInput() {
        try {
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
           
            //객체 생성
           TargetUser = new User(userID, userPW, Name, Age, Gender, Address);

        } catch (IOException ex) {
            Logger.getLogger(AlgoAddAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
