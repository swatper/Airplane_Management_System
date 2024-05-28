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

        // 미리 정의된 값 사용하여 항공편 추가
        //system.addAirPlane("Seoul", "Busan", "국내선", "2024-05-15", 50000, "대한 항공");
        //system.addAirPlane("Busan", "Jeju", "국내선", "2024-05-16", 60000, "아시아나 항공");

        // 모든 항공편 조회
        system.printAllAirPlanes();

        // 미리 정의된 값 사용하여 항공편 수정
        //system.updateAirPlane(0, "Seoul", "Jeju", "국내선", "2024-05-20", 55000, "제주 항공");

        // 수정된 항공편 조회
        system.printAllAirPlanes();

        // 미리 정의된 값 사용하여 항공편 삭제
        system.deleteAirPlane(1);

        // 삭제된 항공편 조회
        system.printAllAirPlanes();
    }
}