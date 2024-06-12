/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-1. 스윙 컴포넌트의 공통 기능, JComponent의 메소드
 */

 package chapter10; 				// chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*; 				// AWT 패키지 임포트
 import java.awt.event.*; 			// AWT 이벤트 패키지 임포트
 import javax.swing.*; 				// 스윙 패키지 임포트
 
 public class JComponentEx extends JFrame { 	// JComponentEx 클래스는 JFrame을 상속받음
	 public JComponentEx() {
		 super("JComponent의 공통 메소드 예제");			// JFrame의 생성자를 호출하여 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 // 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 				 	 // 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 				 	 // 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
		 
		 // 버튼 생성
		 JButton b1 = new JButton("Magenta/Yellow Button");
		 JButton b2 = new JButton("  Disabled Button  ");
		 JButton b3 = new JButton("getX(), getY()");
 
		 // b1 버튼 설정
		 b1.setBackground(Color.YELLOW); 								// 배경색을 노란색으로 설정
		 b1.setForeground(Color.MAGENTA); 								// 글자색을 마젠타색으로 설정
		 b1.setFont(new Font("Arial", Font.ITALIC, 20)); 		// Arial 폰트, 이탤릭체, 크기 20으로 설정
 
		 // b2 버튼 설정
		 b2.setEnabled(false); 		// 버튼을 비활성화
 
		 // b3 버튼에 액션 리스너 추가
		 b3.addActionListener(new ActionListener() { 	// 익명 클래스로 ActionListener 구현
			 public void actionPerformed(ActionEvent e) {
				 JButton b = (JButton)e.getSource(); 		// 이벤트가 발생한 버튼을 가져옴
				 setTitle(b.getX() + "," + b.getY()); 		// 프레임의 타이틀을 버튼의 x, y 좌표로 설정
			 }
		 });
 
		 // 버튼들을 컨텐트 팬에 추가
		 c.add(b1); 
		 c.add(b2); 
		 c.add(b3); 
		 
		 setSize(260, 200); 	// 프레임 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new JComponentEx(); 	// JComponentEx 객체 생성
	 }
 }
 