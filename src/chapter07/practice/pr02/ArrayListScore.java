package chapter07.practice.pr02; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class ArrayListScore {
    public static void main(String[] args) {
        ArrayList<Character> a = new ArrayList<Character>(); 	// Character 타입의 ArrayList 생성
        Scanner scanner = new Scanner(System.in); 				// 사용자 입력을 받기 위한 스캐너 객체 생성

        System.out.print("빈 칸으로 분리하여 5 개의 학점을 입력(A/B/C/D/F)>>");

        // 사용자로부터 5개의 학점을 입력받아 ArrayList에 추가
        for(int i = 0; i < 5; i++) {
            String s = scanner.next(); 							// 문자열로 학점 입력 받기
            if(s.length() > 1) { 								// 입력이 문자 1개가 아닌 경우
                System.out.println("Not character");
                scanner.close(); 								// 스캐너 리소스를 닫고 프로그램 종료
                return;
            }
            char ch = s.charAt(0); 						// 첫 번째 문자를 가져옴

            // 입력된 문자가 유효한 학점 문자(A/B/C/D/F)인지 확인
            if((ch >= 'A' && ch <= 'D') || ch == 'F')
                a.add(ch); 										// 유효한 학점이면 ArrayList에 추가
            else {
                System.out.println("Invalid");
                scanner.close(); 								// 스캐너 리소스를 닫고 프로그램 종료
                return;
            }
        }
        scanner.close(); 										// 스캐너 리소스를 닫음

        double score = 0.0; 									// 학점의 점수를 저장할 변수

        // ArrayList의 각 학점을 순회하며 해당 학점의 점수를 출력
        for(int i = 0; i < a.size(); i++) {
            char ch = a.get(i); 								// ArrayList에서 학점을 가져옴

            // 학점에 따른 점수 매핑
            switch(ch) {
                case 'A' : score = 4.0; break;
                case 'B' : score = 3.0; break;
                case 'C' : score = 2.0; break;
                case 'D' : score = 1.0; break;
                case 'F' : score = 0.0; break;            
            }
            System.out.print(score + " "); 						// 점수를 출력
        }
    }
}
