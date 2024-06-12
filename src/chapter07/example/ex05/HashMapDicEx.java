/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-5. HashMap<String, String>로 (영어, 한글) 단어 쌍으로 저장하고 검색하기
 */

 package chapter07.example.ex05;				// chapter7 패키지에 속하는 클래스임을 명시
 import java.util.*;			// 자바 유틸리티 패키지의 모든 클래스를 임포트
 
 public class HashMapDicEx {
	 public static void main(String[] args) {
		 // 영어 단어와 한글 단어의 쌍을 저장하는 HashMap 컬렉션 생성
		 HashMap<String, String> dic = new HashMap<String, String>();
		 // var dic = new HashMap<String, String>(); 나 HashMap<String, String> dic = new HashMap<>();로도 사용 가능
 
		 // 3 개의 (key, value) 쌍을 dic에 저장
		 dic.put("baby", "아기");		// "baby"는 key, "아기"는 value
		 dic.put("love", "사랑");		// "love"는 key, "사랑"은 value
		 dic.put("apple", "사과");	// "apple"는 key, "사과"는 value
 
		 // dic 해시맵에 들어 있는 모든 (key, value) 쌍 출력
		 Set<String> keys = dic.keySet(); 			// 모든 키를 Set 컬렉션에 받아옴
		 Iterator<String> it = keys.iterator(); 	// Set에 저장된 키 문자열을 접근할 수 있는 Iterator 리턴
		 while(it.hasNext()) {
			 String key = it.next();								// 다음 키
			 String value = dic.get(key);							// 해당 키에 대응하는 값
			 System.out.print("(" + key + "," + value + ")");		// (영어 단어, 한글 단어) 형태로 출력
		 }
		 System.out.println();
 
		 // 사용자로부터 영어 단어를 입력받고 한글 단어 검색
		 Scanner scanner = new Scanner(System.in);		// Scanner 객체 생성
		 for(int i=0; i<3; i++) {
			 System.out.print("찾고 싶은 단어는? ");		// 사용자에게 입력 요구
			 String eng = scanner.next();				  // 사용자로부터 영어 단어 입력받음
			 // 해시맵에서 '키' eng의 '값' kor 검색
			 String kor = dic.get(eng); 	// eng가 해시맵에 없으면 null 리턴
			 if(kor == null) // 검색 결과가 null이면
				 System.out.println(eng + "는 없는 단어입니다.");	  // 해당 단어가 없다는 메시지 출력
			 else
				 System.out.println("한글 뜻: " + kor);				// 검색 결과 출력
		 }
		 scanner.close(); // Scanner 닫기
	 }
 }
 