/*
 * 일자 : 24.05.24 (11week)
 * 범위 : Chapter 9. 자바의 이벤트 처리
 * 예제 : 9-2. 내부 클래스로 Action 이벤트 리스너 만들기
 */

 package chapter09.example.ex02;				// chapter9 패키지에 속하는 클래스임을 명시
 import java.awt.*;				// AWT 패키지 임포트
 import java.awt.event.*;		// AWT 이벤트 패키지 임포트
 import javax.swing.*;			// Swing 패키지 임포트
 
 public class InnerClassListener extends JFrame {
	 public InnerClassListener() {
		 setTitle("Action 이벤트 리스너 예제");			// 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 // 프레임을 닫을 때 프로그램 종료 설정
 
		 Container c = getContentPane();					// 컨텐트팬 얻기
		 c.setLayout(new FlowLayout()); 					// 레이아웃 매니저 설정: FlowLayout
		 JButton btn = new JButton("Action"); 			// 버튼 생성
		 btn.addActionListener(new MyActionListener()); 	// Action 이벤트 리스너 달기
		 c.add(btn); // 버튼 컴포넌트를 컨텐트팬에 추가
 
		 setSize(200, 120); 	// 프레임 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
 
	 /* 내부 클래스로 Action 리스너를 작성 */
	 private class MyActionListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 JButton b = (JButton) e.getSource(); 	// 이벤트 발생 소스로부터 JButton 객체를 얻음
			 if (b.getText().equals("Action"))
				 b.setText("액션");		 // 버튼의 문자열을 "액션"으로 변경
			 else
				 b.setText("Action");		// 버튼의 문자열을 "Action"으로 변경
 
			 /* InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음 */
			 InnerClassListener.this.setTitle(b.getText());		// 프레임의 타이틀에 버튼 문자열을 출력
		 }
	 }
 
	 public static void main(String[] args) {
		 new InnerClassListener();		// InnerClassListener 객체 생성
	 }
 }
 