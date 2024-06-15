/*
 * 일자 : 24.06.07 (13주차)
 * 범위 : Chapter 11. 그래픽
 * 예제 : 11-8. repaint()와 마우스를 이용한 여러 개의 선 그리기
 */

 package chapter11.example.ex08; 				// chapter11 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 				// javax.swing 패키지의 모든 클래스를 임포트
 import java.awt.*; 				// java.awt 패키지의 모든 클래스를 임포트
 import java.awt.event.*; 			// java.awt 이벤트 관련 패키지를 임포트
 import java.util.*; 				// java.util 패키지의 모든 클래스를 임포트
 
 // GraphicsDrawLineMouseEx 클래스는 JFrame을 상속받는다.
 public class GraphicsDrawLineMouseEx extends JFrame {
	 
	 // GraphicsDrawLineMouseEx 생성자
	 public GraphicsDrawLineMouseEx() {
		 setTitle("마우스로 여러 개의 선 그리기 예제"); 		 // 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
		 setContentPane(new MyPanel()); 						// 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
		 
		 setSize(300, 300); 						// 프레임의 크기를 가로 300, 세로 300으로 설정
		 setVisible(true); 									// 프레임을 화면에 보이도록 설정
	 }
 
	 // main 메서드: 프로그램의 시작점
	 public static void main(String[] args) {
		 new GraphicsDrawLineMouseEx(); 	// GraphicsDrawLineMouseEx 객체를 생성하여 프로그램을 실행
	 }
	 
	 // 선을 그릴 수 있는 패널을 구현한다.
	 // 이 패널에 Mouse 리스너를 구현한다.
	 class MyPanel extends JPanel {
		 // 그려진 선을 모두 저장하기 위해 시작점은 vStart에 
		 // 끝점은 vEnd 벡터에 각각 저장한다.
		 private Vector<Point> vStart = new Vector<Point>();
		 private Vector<Point> vEnd = new Vector<Point>();
		 
		 // MyPanel 생성자
		 public MyPanel() {
			 
			 // Mouse 리스너를 등록한다. 
			 // 이 리스너는 마우스 버튼이 눌러지면 마우스 포인터(시작점)를 vStart 벡터에 저장하고
			 // 마우스 버튼이 놓여지면 마우스 포인터(끝점)를 vEnd 벡터에 기억한다.
			 addMouseListener(new MouseAdapter(){
				 // 마우스 버튼이 눌렸을 때 호출되는 메서드
				 public void mousePressed(MouseEvent e) {
					 Point startP = e.getPoint();		 	// 마우스 포인터를 알아낸다.
					 vStart.add(startP); 					// 시작점을 vStart에 저장한다.
				 }
				 
				 // 마우스 버튼이 놓여졌을 때 호출되는 메서드
				 public void mouseReleased(MouseEvent e) {
					 Point endP = e.getPoint(); 			// 마우스 포인터를 알아낸다.
					 vEnd.add(endP); 						// 끝점을 vEnd에 저장한다.
					 
					 // 패널의 다시 그리기를 요청한다. 
					 repaint();
				 }                
			 });            
		 }
		 
		 // paintComponent 메서드 오버라이딩
		 public void paintComponent(Graphics g) {
			 super.paintComponent(g); 						// 부모 클래스(JPanel)의 paintComponent 메서드 호출
			 g.setColor(Color.BLUE); 						// 파란색을 선택한다.
			 
			 // 벡터의 크기만큼 루프 돌면서 선을 그린다.
			 for (int i = 0; i < vStart.size(); i++) { 		// vStart 벡터의 크기는 만들어진 선의 개수와 동일
				 Point s = vStart.elementAt(i); 			// 벡터에 들어 있는 시작점을 알아낸다.
				 Point e = vEnd.elementAt(i); 				// 벡터에 들어 있는 끝점을 알아낸다.
				 
				 // 시작점에서 끝점까지 선을 그린다.
				 g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());                
			 }
		 }
	 }
 }
 