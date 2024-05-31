/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;

/**
 *
 * @author 박규리
 */
// 만족도 및 피드백 조회

public class FeedbackReport implements Report {
@Override
    public void generateReport() {
        System.out.println("======================================");
        System.out.println("만족도 및 피드백 조회");
        
        String filePath =  System.getProperty("user.dir") + "\\src\\main\\java\\cse\\airplane_management_system\\ReportSystem\\feedback.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("피드백 파일이 존재하지 않습니다.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 동안 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}