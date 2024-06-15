/*
 * 일자 : 24.06.07 (13주차)
 * 범위 : Chapter 11. 그래픽
 * 예제 : 11-2. Color와 Font를 이용하여 문자열 그리기
 */

 package chapter11.example.ex02; 				// chapter11 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 				// javax.swing 패키지의 모든 클래스를 임포트
 import java.awt.*; 				// java.awt 패키지의 모든 클래스를 임포트
 
 // GraphicsColorFontEx 클래스는 JFrame을 상속받는다.
 public class GraphicsColorFontEx extends JFrame {
	 
	 // GraphicsColorFontEx 생성자
	 public GraphicsColorFontEx() {
		 setTitle("문자열, Color, Font 사용 예제"); 			  // 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 			// 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
		 setContentPane(new MyPanel()); 							// 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
		 
		 setSize(300, 300); 							// 프레임의 크기를 가로 300, 세로 300으로 설정
		 setVisible(true); 										// 프레임을 화면에 보이도록 설정
	 }
 
	 // JPanel을 상속받아 MyPanel 클래스 선언
	 class MyPanel extends JPanel {
		 
		 // paintComponent 메서드 오버라이딩
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g); 											// 부모 클래스(JPanel)의 paintComponent 메서드 호출
			 
			 g.setColor(Color.BLUE); 											// 파란색 지정
			 g.drawString("자바가 정말 재밋다.~~", 30, 30);				   // (30, 30) 위치에 문자열 출력
			 
			 g.setColor(new Color(255, 0, 0)); 							// 빨간색 지정
			 g.setFont(new Font("Arial", Font.ITALIC, 30)); 			// Arial, 기울임꼴, 크기 30 폰트 지정
			 g.drawString("How much?", 30, 70); 						// (30, 70) 위치에 문자열 출력
			 
			 g.setColor(new Color(0x00ff00ff)); 							// RGB 값 (r=ff, g=00, b=ff)로 보라색 지정
			 
			 // 4번 반복하여 폰트 크기를 점점 키우면서 문자열 출력
			 for(int i = 1; i <= 4; i++) {
				 g.setFont(new Font("Jokerman", Font.ITALIC, i * 10)); 	// Jokerman, 기울임꼴, 크기 i*10 폰트 지정
				 g.drawString("This much!!", 30, 60 + i * 40); 			// (30, 60 + i*40) 위치에 문자열 출력
			 }
		 }
	 }
	 
	 // main 메서드: 프로그램의 시작점
	 public static void main(String[] args) {
		 new GraphicsColorFontEx(); 	// GraphicsColorFontEx 객체를 생성하여 프로그램을 실행
	 }
 }
 