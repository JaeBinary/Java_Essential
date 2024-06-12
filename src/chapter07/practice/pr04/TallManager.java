package chapter07.practice.pr04; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class TallManager {
    public static void main(String[] args) {
        Vector<Double> height = new Vector<Double>(); 				// 키(cm)를 저장할 Vector 생성
        Scanner scanner = new Scanner(System.in); 					// 사용자 입력을 받기 위한 스캐너 객체 생성
        
        // 2000~2009년까지 각 년도별 키(cm)를 입력받아 Vector에 추가
        System.out.println("2000~2009년까지 1년 단위로 키(cm)를 입력");
        for (int i = 0; i < 10; i++) {
            System.out.print(">>");
            double tall = scanner.nextDouble(); // 키 입력 받기
            height.add(tall); // 입력받은 키를 Vector에 추가
        }

        double bigDistance = 0.0; 									// 가장 큰 키 증가량을 저장할 변수
        int year = 0; 												// 가장 큰 키 증가량이 발생한 년도를 저장할 변수
        
        // 키 증가량을 계산하여 가장 많이 자란 년도를 찾는 로직
        for(int i = 0; i < height.size() - 1; i++) {
            double distance = height.get(i + 1) - height.get(i); 	// i년도와 i+1년도 사이의 키 증가량 계산
            if(bigDistance < distance) { 							// 현재 저장된 가장 큰 키 증가량보다 크면
                bigDistance = distance; 							// 가장 큰 키 증가량 갱신
                year = i; 											// 해당 년도를 저장
            }
        }
        
        // 가장 키가 많이 자란 년도를 출력
        System.out.println("가장 키가 많이 자란 년도는 " + (year + 2000) + "년 " + bigDistance + "cm");
        
        scanner.close(); 											// 스캐너 리소스를 닫음
    }
}
