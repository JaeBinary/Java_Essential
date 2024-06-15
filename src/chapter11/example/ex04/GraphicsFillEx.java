/*
 * 일자 : 24.06.07 (13주차)
 * 범위 : Chapter 11. 그래픽
 * 예제 : 11-4. 도형 칠하기
 */

 package chapter11.example.ex04; 				// chapter11 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 				// javax.swing 패키지의 모든 클래스를 임포트
 import java.awt.*; 				// java.awt 패키지의 모든 클래스를 임포트

public class GraphicsFillEx extends JFrame {
	public GraphicsFillEx() {
		setTitle("fillXXX 사용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		
		setSize(100, 350);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10,10,50,50); // 빨간색 사각형 칠하기
			g.setColor(Color.BLUE);
			g.fillOval(10,70,50,50); // 파란색 타원 칠하기
			g.setColor(Color.GREEN);
			g.fillRoundRect(10,130,50,50, 20,20); // 초록색 둥근사각형 칠하기
			g.setColor(Color.MAGENTA);
			g.fillArc(10, 190, 50, 50, 0, 270); // 마젠타색 원호 칠하기
			g.setColor(Color.ORANGE);
			int []x ={30,10,30,60};
			int []y ={250,275,300,275};
			g.fillPolygon(x, y, 4);	// 오렌지색 다각형 칠하기		
		}
	}
	
	public static void main(String [] args) {
		new GraphicsFillEx();
	}
} 