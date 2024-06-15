/*
 * 일자 : 24.06.07 (13week)
 * 범위 : Chapter 12. 자바 스레드 기초
 * 예제 : 12-1. Thread를 상속받아 1초 단위 타이머 스레드 만들기
 */

 package chapter12.example.ex01;                // chapter12 패키지에 속하는 클래스임을 명시
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 class TimerThread extends Thread {
	 private JLabel timerLabel; 			// 타이머 값이 출력되는 레이블
	 
	 public TimerThread(JLabel timerLabel) {
		 this.timerLabel = timerLabel; 		// 타이머 카운트를 출력할 레이블
	 }
 
	 // 스레드 코드. run()이 종료하면 스레드 종료
	 @Override
	 public void run() {
		 int n = 0; 		// 타이머 카운트 값
		 while (true) { 	// 무한 루프
			 timerLabel.setText(Integer.toString(n)); 	// 레이블에 카운트 값 출력
			 n++; 										// 카운트 증가
			 try {
				 Thread.sleep(1000); 			// 1초동안 잠을 잔다.
			 } catch (InterruptedException e) {
				 return; 								// 예외가 발생하면 스레드 종료
			 }
		 }
	 }
 }
 
 public class ThreadTimerEx extends JFrame {
	 public ThreadTimerEx() {
		 setTitle("Thread를 상속받은 타이머 스레드 예제"); 		// 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 			// 프레임 닫기 버튼 클릭 시 프로그램 종료
		 Container c = getContentPane(); 							// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 							// 레이아웃 매니저를 FlowLayout으로 설정
		 setSize(250, 150); 							// 프레임 크기 설정
		 setVisible(true); 										// 프레임을 화면에 표시
 
		 // 타이머 값을 출력할 레이블 생성
		 JLabel timerLabel = new JLabel();
		 timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80)); 		// 폰트 설정
		 c.add(timerLabel); 														// 레이블을 컨텐트팬에 부착
 
		 // 타이머 스레드 객체 생성. 타이머 값을 출력할 레이블을 생성자에 전달
		 TimerThread th = new TimerThread(timerLabel);
 
		 
 
		 th.start(); 						// 타이머 스레드의 실행을 시작하게 한다.
	 }
 
	 public static void main(String[] args) {
		 new ThreadTimerEx(); 				// ThreadTimerEx 객체 생성하여 프레임 실행
	 }
 }
 