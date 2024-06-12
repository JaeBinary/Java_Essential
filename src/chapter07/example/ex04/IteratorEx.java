/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-4. Iterator<Integer>를 이용하여 정수 벡터 검색
 */

 package chapter07.example.ex04;				// chapter7 패키지에 속하는 클래스임을 명시
 import java.util.*;			// 자바 유틸리티 패키지의 모든 클래스를 임포트
 
 public class IteratorEx {
	 public static void main(String[] args) {
		 // 정수 값만 다루는 제네릭 벡터 생성
		 Vector<Integer> v = new Vector<Integer>();
		 v.add(5);	// 5를 벡터에 추가
		 v.add(4);	// 4를 벡터에 추가
		 v.add(-1);		// -1을 벡터에 추가
		 v.add(2, 100);	// 4와 -1 사이에 100을 삽입
 
		 // Iterator를 이용한 모든 정수 출력
		 Iterator<Integer> it = v.iterator();	// Iterator 객체 얻기
		 while(it.hasNext()) {		// 다음 요소가 있는지 확인
			 int n = it.next();			// 다음 요소 가져오기
			 System.out.println(n);		// 정수 출력
		 }
 
		 // Iterator를 이용하여 모든 정수 더하기
		 int sum = 0;			// 합을 저장할 변수 초기화
		 it = v.iterator();		// Iterator 객체 얻기
		 while(it.hasNext()) {		// 다음 요소가 있는지 확인
			 int n = it.next();			// 다음 요소 가져오기
			 sum += n; 					// sum에 더하기
		 }
		 // 합 출력
		 System.out.println("벡터에 있는 정수 합 : " + sum);
	 }
 }
 