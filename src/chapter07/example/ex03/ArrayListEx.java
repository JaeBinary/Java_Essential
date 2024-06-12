/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-3. 문자열만 다루는 ArrayList<String> 활용
 */

 package chapter07.example.ex03;				// chapter7 패키지에 속하는 클래스임을 명시
 import java.util.*;			// 자바 유틸리티 패키지의 모든 클래스를 임포트
 
 public class ArrayListEx {
	 public static void main(String[] args) {
		 // 문자열만 삽입 가능한 ArrayList 컬렉션 생성
		 ArrayList<String> a = new ArrayList<String>();
 
		 // 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
		 Scanner scanner = new Scanner(System.in);	// Scanner 객체 생성
		 for(int i=0; i<4; i++) {
			 System.out.print("이름을 입력하세요>>");		// 사용자에게 입력 요구
			 String s = scanner.next();					// 키보드로부터 이름을 입력받음
			 a.add(s); 									// ArrayList 컬렉션에 이름 추가
		 }
		 
		 // ArrayList에 들어 있는 모든 이름 출력
		 for(int i=0; i<a.size(); i++) {
			 String name = a.get(i); 			// ArrayList의 i번째 문자열 가져오기
			 System.out.print(name + " "); 		// 이름 출력
		 }
		 
		 // 가장 긴 이름 출력
		 int longestIndex = 0; 		// 현재 가장 긴 이름이 있는 ArrayList 내의 인덱스
		 for(int i=1; i<a.size(); i++) {
			 if(a.get(longestIndex).length() < a.get(i).length()) 	// 이름 길이 비교
				 longestIndex = i; 		// i 번째 이름이 더 긴 이름임
		 }
		 System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex)); 	// 가장 긴 이름 출력
		 scanner.close(); 	// Scanner 닫기
	 }
 }
 