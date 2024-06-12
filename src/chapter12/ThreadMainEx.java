/*
 * 일자 : 24.06.07 (13week)
 * 범위 : Chapter 12. 자바 스레드 기초
 * 예제 : 12-3. main 스레드 확인과 스레드 정보를 알아내는 코드
 */

 package chapter12;                // chapter12 패키지에 속하는 클래스임을 명시

 public class ThreadMainEx {
	 public static void main(String[] args) {
		 long id = Thread.currentThread().getId(); 					// 현재 실행 중인 스레드의 ID를 얻는다.
		 String name = Thread.currentThread().getName(); 			// 현재 실행 중인 스레드의 이름을 얻는다.
		 int priority = Thread.currentThread().getPriority(); 		// 현재 실행 중인 스레드의 우선순위를 얻는다.
		 Thread.State s = Thread.currentThread().getState(); 		// 현재 실행 중인 스레드의 상태를 얻는다.
 
		 // 현재 실행 중인 스레드의 정보를 출력한다.
		 System.out.println("현재 스레드 이름 = " + name);
		 System.out.println("현재 스레드 ID = " + id);
		 System.out.println("현재 스레드 우선순위 값 = " + priority);
		 System.out.println("현재 스레드 상태 = " + s);
	 }
 }
 