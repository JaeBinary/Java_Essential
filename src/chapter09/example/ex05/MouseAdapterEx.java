/*
 * 일자 : 24.05.24 (11week)
 * 범위 : Chapter 9. 자바의 이벤트 처리
 * 예제 : 9-5. MouseAdapter로 마우스 리스너 작성
 */

 package chapter09.example.ex05;				// chapter9 패키지에 속하는 클래스임을 명시
 import java.awt.*;				// AWT 패키지 임포트
 import java.awt.event.*;		// AWT 이벤트 패키지 임포트
 import javax.swing.*;			// Swing 패키지 임포트
 
 public class MouseAdapterEx extends JFrame {
	 private JLabel la = new JLabel("Hello"); 	// "Hello" 문자열을 출력하기 위한 레이블 컴포넌트
 
	 public MouseAdapterEx() {
		 setTitle("Mouse 이벤트 예제"); 					// 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	  // 프레임을 닫을 때 프로그램 종료 설정
 
		 Container c = getContentPane(); 				// 컨텐트팬 얻기
		 c.addMouseListener(new MyMouseAdapter()); 		// 컨텐트팬에 Mouse 이벤트 리스너 달기
 
		 c.setLayout(null); 				// 컨텐트팬의 배치관리자 삭제
		 la.setSize(50, 20); 		// 레이블의 크기 50x20 설정
		 la.setLocation(30, 30); 			// 레이블의 위치 (30,30)으로 설정
		 c.add(la); 							// 레이블 컴포넌트 삽입
 
		 setSize(200, 200); 		// 프레임 크기 설정
		 setVisible(true); 					// 프레임을 화면에 표시
	 }
 
	 class MyMouseAdapter extends MouseAdapter { 	// MouseAdapter를 상속받아 리스너 구현
		 public void mousePressed(MouseEvent e) {
			 int x = e.getX(); 			// 마우스 클릭 좌표 x
			 int y = e.getY(); 			// 마우스 클릭 좌표 y
			 la.setLocation(x, y); 		// 레이블의 위치를 (x,y)로 이동
		 }
	 }
 
	 public static void main(String[] args) {
		 new MouseAdapterEx(); 		// MouseAdapterEx 객체 생성
	 }
 }
 