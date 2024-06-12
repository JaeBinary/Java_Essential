/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-1. 정수만 다루는 Vector<Integer> 컬렉션 활용
 */

 package chapter07.example.ex01; 				// chapter7 패키지에 속하는 클래스임을 명시
 import java.util.Vector; 		// 자바 유틸리티 패키지에서 Vector 클래스를 임포트
 
 public class VectorEx {
	 public static void main(String[] args) {
		 // 정수 값만 다루는 제네릭 벡터 생성
		 Vector<Integer> v = new Vector<Integer>(); // Integer 타입의 벡터 객체 생성
		 // var v = new Vector<Integer>(); 또는 Vector<Integer> v = new Vector<>(); 로도 사용 가능
 
		 v.add(5);	// 5를 벡터에 추가
		 v.add(4);	// 4를 벡터에 추가
		 v.add(-1);		// -1을 벡터에 추가
		 
		 // 벡터 중간에 삽입하기
		 v.add(2, 100);	// 인덱스 2에 100을 삽입
 
		 // 벡터의 크기 출력
		 System.out.println("벡터 내의 요소 객체 수 : " + v.size());	 // 현재 벡터의 요소 개수 출력
		 // 벡터의 용량 출력
		 System.out.println("벡터의 현재 용량 : " + v.capacity());		// 현재 벡터의 용량 출력 (디폴트 용량은 10)
 
		 // 벡터의 모든 요소 출력
		 for(int i=0; i<v.size(); i++) {
			 int n = v.get(i); 			// 벡터의 i번째 요소 가져오기
			 System.out.println(n); 	// 요소 출력
		 }
 
		 // 벡터의 모든 정수 더하기
		 int sum = 0; 	// 합을 저장할 변수 초기화
		 for(int i=0; i<v.size(); i++) {
			 int n = v.elementAt(i); 	// 벡터의 i번째 요소 가져오기
			 sum += n; 					// sum에 더하기
		 }
		 // 합 출력
		 System.out.println("벡터에 있는 정수 합 : " + sum);
	 }
 }
 