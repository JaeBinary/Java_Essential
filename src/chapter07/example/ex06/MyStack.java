/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-6. 제네릭 스택 만들기
 */

 package chapter07.example.ex06;				// chapter7 패키지에 속하는 클래스임을 명시

 class GStack<T> { 	// 제네릭 스택 선언. 제네릭 타입 T
	 int tos; 			// top of stack, 스택에 저장된 요소의 개수
	 Object[] stck;		// 요소를 저장할 배열
 
	 public GStack() {
		 tos = 0; 					// 스택 초기화
		 stck = new Object[10]; 	// 10개의 요소를 저장할 수 있는 배열 생성
	 }
 
	 public void push(T item) {
		 if(tos == 10) 	// 스택이 꽉 차서 더 이상 요소를 삽입할 수 없음
			 return;
		 stck[tos] = item; 		// 요소를 스택에 삽입
		 tos++; 				// tos 증가
	 }
 
	 public T pop() {
		 if(tos == 0) 			// 스택이 비어 있어 꺼낼 요소가 없음
			 return null;
		 tos--; // tos 감소
		 return (T) stck[tos]; 	// 요소를 스택에서 꺼내서 반환
	 }
 }
 
 public class MyStack {
	 public static void main(String[] args) {
		 GStack<String> stringStack = new GStack<String>(); 	// String 타입의 GStack 생성
		 stringStack.push("seoul");
		 stringStack.push("busan");
		 stringStack.push("LA");
 
		 for(int n = 0; n < 3; n++)
			 System.out.println(stringStack.pop()); 	// stringStack 스택에 있는 3개의 문자열 팝
 
		 GStack<Integer> intStack = new GStack<Integer>(); 		// Integer 타입의 GStack 생성
		 intStack.push(1);
		 intStack.push(3);
		 intStack.push(5);
 
		 for(int n = 0; n < 3; n++)
			 System.out.println(intStack.pop()); 		// intStack 스택에 있는 3개의 정수 팝
	 }
 }
 