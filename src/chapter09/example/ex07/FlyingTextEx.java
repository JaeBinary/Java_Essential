/*
 * 일자 : 24.05.24 (11week)
 * 범위 : Chapter 9. 자바의 이벤트 처리
 * 예제 : 9-7. keyListener 활용 - 상, 하, 좌, 우 키로 문자열 움직이기
 */

 package chapter09.example.ex07;				// chapter9 패키지에 속하는 클래스임을 명시
 import java.awt.*;				// AWT 패키지 임포트
 import java.awt.event.*;		// AWT 이벤트 패키지 임포트
 import javax.swing.*;			// Swing 패키지 임포트
 
 public class FlyingTextEx extends JFrame {
	 private JLabel la = new JLabel("HELLO"); // 키 입력에 따라 움직일 레이블 컴포넌트
 
	 public FlyingTextEx() {
		 super("상,하,좌,우 키를 이용하여 텍스트 움직이기"); 		// 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		   // 프로그램 종료 설정
 
		 Container c = getContentPane(); 			// 컨텐트 팬 알아내기
		 c.setLayout(null); 					// 컨텐트팬의 배치관리자 삭제
		 c.addKeyListener(new MyKeyListener()); 	// 컨텐트팬에 키 리스너 달기
		 la.setLocation(50, 50); 				// 레이블의 초기 위치는 (50,50)
		 la.setSize(100, 20);
		 c.add(la); 								// 레이블 추가
		 setSize(200, 200); 			// 프레임 크기 설정
		 setVisible(true); 						// 프레임을 화면에 표시
 
		 c.setFocusable(true); 			// 컨텐트팬이 포커스를 받을 수 있도록 설정
		 c.requestFocus(); 							// 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
	 }
 
	 class MyKeyListener extends KeyAdapter { 	// Key 리스너 구현
		 public void keyPressed(KeyEvent e) {
			 int keyCode = e.getKeyCode(); 	// 입력된 키의 키코드를 알아낸다.
			 switch (keyCode) { 	// 키 코드에 따라 상,하,좌,우 키 판별, 레이블의 위치 이동
				 case KeyEvent.VK_UP: 		// UP 키
					 la.setLocation(la.getX(), la.getY() - 10);
					 break;
				 case KeyEvent.VK_DOWN: 	// DOWN 키
					 la.setLocation(la.getX(), la.getY() + 10);
					 break;
				 case KeyEvent.VK_LEFT: 	// LEFT 키
					 la.setLocation(la.getX() - 10, la.getY());
					 break;
				 case KeyEvent.VK_RIGHT: 	// RIGHT 키
					 la.setLocation(la.getX() + 10, la.getY());
					 break;
			 }
		 }
	 }
 
	 public static void main(String[] args) {
		 new FlyingTextEx(); 	// FlyingTextEx 객체 생성
	 }
 }
 