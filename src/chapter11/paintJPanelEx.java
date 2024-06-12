/*
 * 일자 : 24.06.07 (13주차)
 * 범위 : Chapter 11. 그래픽
 * 예제 : 11-1. JPanel을 상속받은 패널에 도형 그리기
 */

 package chapter11; 				// chapter11 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 				// javax.swing 패키지의 모든 클래스를 임포트
 import java.awt.*; 				// java.awt 패키지의 모든 클래스를 임포트
 
 // paintJPanelEx 클래스는 JFrame을 상속받는다.
 public class paintJPanelEx extends JFrame {

	 // paintJPanelEx 생성자
	 public paintJPanelEx() {
		 setTitle("JPanel의 paintComponent() 예제"); 		 // 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
		 setContentPane(new MyPanel());							// MyPanel 패널을 프레임의 컨텐트팬으로 설정
		 
		 setSize(250, 200); 						// 프레임의 크기를 가로 250, 세로 200으로 설정
		 setVisible(true); 									// 프레임을 화면에 보이도록 설정
	 }
 
	 // JPanel을 상속받는 MyPanel 클래스 선언
	 class MyPanel extends JPanel {

		 // paintComponent 메서드 오버라이딩
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g); 		// 부모 클래스(JPanel)의 paintComponent 메서드 호출
			 
			 // 파란색을 선택
			 g.setColor(Color.BLUE);
			 // (10, 10) 위치에 50x50 크기의 사각형을 그린다
			 g.drawRect(10, 10, 50, 50);
			 // (50, 50) 위치에 50x50 크기의 사각형을 그린다
			 g.drawRect(50, 50, 50, 50);
			 
			 // 마젠타색을 선택
			 g.setColor(Color.MAGENTA);
			 // (90, 90) 위치에 50x50 크기의 사각형을 그린다
			 g.drawRect(90, 90, 50, 50);
		 }
	 }
	 
	 // main 메서드: 프로그램의 시작점
	 public static void main(String[] args) {
		 new paintJPanelEx(); 				// paintJPanelEx 객체를 생성하여 프로그램을 실행
	 }
 }
 