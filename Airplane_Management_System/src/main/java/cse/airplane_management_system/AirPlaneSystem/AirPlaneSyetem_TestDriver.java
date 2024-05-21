/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlaneSystem;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kb010
 */
public class AirPlaneSyetem_TestDriver {
      public static void main(String[] args) throws IOException {
        AirPlaneSystem system = new AirPlaneSystem();

        // 항공편 추가
        system.addAirPlane("Seoul", "Busan", "Domestic", "2024-05-15");
        system.addAirPlane("Busan", "Jeju", "Domestic", "2024-05-16");

        // 모든 항공편 조회
        system.printAllAirPlanes();

        // 항공편 수정
        system.updateAirPlane(0, "Seoul", "Jeju", "Domestic", "2024-05-20");

        // 수정된 항공편 조회
        system.printAllAirPlanes();

        // 항공편 삭제
        system.deleteAirPlane(1);

        // 삭제된 항공편 조회
        system.printAllAirPlanes();
        
        /*try {
            system.RunSystem();
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }*/
    }   
    }

    //실행 코드 메인에 넣으면 됨
  /*
        try {
            AirPlaneSystem system = new AirPlaneSystem();
            system.RunSystem();
        } catch (IOException e) {
            System.err.println("파일 처리 중 오류 발생: " + e.getMessage());
        }
    }   
*/