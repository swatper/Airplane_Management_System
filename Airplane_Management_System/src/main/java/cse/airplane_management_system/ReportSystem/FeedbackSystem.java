/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import java.io.IOException; // 입출력 예외 처리를 위한 클래스 import
import java.io.PrintWriter; // PrintWriter 클래스 import
import java.util.Scanner; // 사용자 입력을 받기 위한 클래스 import
import java.io.FileOutputStream; 
import java.io.OutputStreamWriter; 

/**
 *
 * @author 박규리
 */

public class FeedbackSystem {
        // collectFeedback 메소드 - 사용자로부터 만족도와 피드백을 입력받음.
        //만족도는 0에서 10 사이의 숫자로 제한하고, 잘못된 입력(숫자가 아닌 경우)이나 범위를 벗어난 입력에 대한 예외 처리를 포함.
        public void collectFeedback() {     
            Scanner scanner = new Scanner(System.in);
            double satisfaction = -1; // 초기값 설정
            while (satisfaction < 0 || satisfaction > 10) { // 올바른 범위의 값이 입력될 때까지 반복
                System.out.println("================================================================================");
                System.out.print("만족도를 입력해주세요 (0-10): ");
                String input = scanner.nextLine(); // 사용자 입력을 문자열로 받음

                try {
                    satisfaction = Double.parseDouble(input); // 문자열을 실수로 변환
                    if (satisfaction < 0 || satisfaction > 10) { // 범위를 벗어난 값인지 확인
                        System.out.println("================================================================================");
                        System.out.println("0에서 10 사이의 숫자를 입력해주세요.");        
                }
            } catch (NumberFormatException e) {
                System.out.println("================================================================================");
                System.out.println("0에서 10 사이의 숫자를 입력해주세요.");
            }
        }
        
        System.out.println("================================================================================");
        System.out.println("항공권 예매 시스템을 이용하시면서 느낀 점이 있으시면 알려주세요: ");
        String feedback = scanner.nextLine();
        System.out.println("================================================================================");

        saveFeedbackToFile(satisfaction, feedback);
        scanner.close();
    }

    private void saveFeedbackToFile(double satisfaction, String feedback) {
        String filePath = "feedback.txt";
        
        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {
            printWriter.println("만족도: " + satisfaction);
            printWriter.println("피드백: " + feedback);
            printWriter.println("------------------------------");
        } catch (IOException e) {
            System.out.println("피드백을 저장하는 동안 오류가 발생했습니다.");
            e.printStackTrace(); // 예외의 상세 정보를 출력하여 문제를 진단하는 데 도움을 줌
        }
    }
}

