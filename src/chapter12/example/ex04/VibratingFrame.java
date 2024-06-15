/*
 * 일자 : 24.06.07 (13week)
 * 범위 : Chapter 12. 자바 스레드 기초
 * 예제 : 12-4. 진동하는 스레드와 스레드의 강제 종료
 */

 package chapter12.example.ex04;                // chapter12 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;		   // AWT 이벤트 관련 패키지를 가져옴
 import javax.swing.*; 			   // Swing 패키지를 가져옴
 import java.util.Random; 		   // Random 클래스를 사용하기 위해 java.util 패키지를 가져옴
 
 public class VibratingFrame extends JFrame implements Runnable { 	// VibratingFrame 클래스를 JFrame 클래스를 확장하고 Runnable 인터페이스를 구현함
	 private Thread th; 			// 진동하는 스레드를 저장할 변수 선언
 
	 public VibratingFrame() { 		// 생성자
		 setTitle("진동하는 프레임 만들기"); 				// 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	 // 프레임이 닫힐 때 프로그램 종료
		 setSize(200, 200); 					 // 프레임 크기 설정
		 setLocation(300, 300); 						 // 프레임 위치 설정 (x, y)
		 setVisible(true); 								 // 프레임을 화면에 표시
 
		 getContentPane().addMouseListener(new MouseAdapter() { 	// 마우스 이벤트 처리를 위한 익명 내부 클래스 생성
			 public void mousePressed(MouseEvent e) { 				// 마우스 클릭 이벤트 핸들러
				 if (!th.isAlive()) 								// 스레드가 이미 종료되었다면
					 return; 										// 아무 작업도 수행하지 않고 종료
				 th.interrupt(); 									// 진동 스레드에게 InterruptedException을 보냄
			 }
		 });
 
		 th = new Thread(this); 	// 진동하는 스레드 객체 생성
		 th.start(); 				// 진동 시작
	 }
 
	 @Override
	 public void run() { 			// 스레드 실행 메서드
		 Random r = new Random(); 	// 랜덤 객체 생성
		 while (true) { 			// 무한 반복
			 try {
				 Thread.sleep(20); 			// 20ms 동안 스레드를 일시 중지
			 } catch (InterruptedException e) { 	// InterruptedException이 발생하면
				 return; 							// 스레드 종료
			 }
			 int x = getX() + r.nextInt() % 5; 		// 현재 x 좌표에 랜덤 값을 더함
			 int y = getY() + r.nextInt() % 5; 		// 현재 y 좌표에 랜덤 값을 더함
			 setLocation(x, y); 					// 프레임의 위치를 변경
		 }
	 }
 
	 public static void main(String[] args) {
		 new VibratingFrame(); 						// VibratingFrame 객체 생성
	 }
 }
