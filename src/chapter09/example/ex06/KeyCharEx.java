/*
 * 일자 : 24.05.24 (11week)
 * 범위 : Chapter 9. 자바의 이벤트 처리
 * 예제 : 9-6. KeyListener 활용 - 입력된 문자 키 입력
 */

 package chapter09.example.ex06;				// chapter9 패키지에 속하는 클래스임을 명시
 import java.awt.*;				// AWT 패키지 임포트
 import java.awt.event.*;		// AWT 이벤트 패키지 임포트
 import javax.swing.*;			// Swing 패키지 임포트
 
 public class KeyCharEx extends JFrame {
	 private JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다");
 
	 public KeyCharEx() {
		 super("KeyListener의 문자 키 입력 예제"); 		// 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	 // 프로그램 종료 설정
 
		 Container c = getContentPane(); 	// 컨텐트 팬 알아내기
		 c.setLayout(new FlowLayout()); 	// FlowLayout으로 레이아웃 설정
		 c.add(la); 						// 레이블 추가
 
		 c.addKeyListener(new MyKeyListener()); 	// 키 리스너 추가
 
		 setSize(250, 150); 			// 프레임 크기 설정
		 setVisible(true); 						// 프레임을 화면에 표시
 
		 c.setFocusable(true); 			// 컨텐트팬이 포커스를 받을 수 있도록 설정
		 c.requestFocus(); 							// 컨텐트 팬에 포커스 설정. 키 입력 가능해짐
	 }
 
	 class MyKeyListener extends KeyAdapter { // 키 리스너
		 public void keyPressed(KeyEvent e) {
			 // 임의의 색을 만들기 위해 랜덤하게 r, g, b 성분 생성
			 int r = (int) (Math.random() * 256); 	// 0~255 사이의 임의의 red 성분
			 int g = (int) (Math.random() * 256); 	// 0~255 사이의 임의의 green 성분
			 int b = (int) (Math.random() * 256); 	// 0~255 사이의 임의의 blue 성분
 
			 switch (e.getKeyChar()) { 	// 입력된 키 문자
				 case '\n': 	// <Enter> 키 입력
					 la.setText("r=" + r + ", g=" + g + ", b=" + b);
					 getContentPane().setBackground(new Color(r, g, b)); 	// 컨텐트팬의 배경색 설정
					 break;
				 case 'q':
					 System.exit(0); 								// 프로그램 종료
			 }
		 }
	 }
 
	 public static void main(String[] args) {
		 new KeyCharEx(); 	// KeyCharEx 객체 생성
	 }
 }
 