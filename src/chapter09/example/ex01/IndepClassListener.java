/*
 * 일자 : 24.05.24 (11week)
 * 범위 : Chapter 9. 자바의 이벤트 처리
 * 예제 : 9-1. 독립 클래스로 Action 이벤트 리스너 만들기
 */

 package chapter09.example.ex01;				// chapter9 패키지에 속하는 클래스임을 명시
 import java.awt.*;				// AWT 패키지 임포트
 import java.awt.event.*;		// AWT 이벤트 패키지 임포트
 import javax.swing.*;			// Swing 패키지 임포트
 
 public class IndepClassListener extends JFrame {
	 public IndepClassListener() {
		 setTitle("Action 이벤트 리스너 예제");			// 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	 // 프레임을 닫을 때 프로그램 종료 설정
 
		 Container c = getContentPane();					// 컨텐트팬 얻기
		 c.setLayout(new FlowLayout());						// 레이아웃 매니저 설정: FlowLayout
		 JButton btn = new JButton("Action");			// 버튼 생성
		 btn.addActionListener(new MyActionListener());		// Action 이벤트 리스너 달기
		 c.add(btn); 										// 버튼 컴포넌트를 컨텐트팬에 추가
 
		 setSize(250, 120); 	// 프레임 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new IndepClassListener(); 	// IndepClassListener 객체 생성
	 }
 }
 
 /* 독립된 클래스로 이벤트 리스너를 작성 */
 class MyActionListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
		 JButton b = (JButton) e.getSource(); 	// 이벤트 발생 소스로부터 JButton 객체를 얻음
		 if (b.getText().equals("Action")) 	// 버튼의 문자열이 "Action"인지 확인
			 b.setText("액션");		 // 버튼의 문자열을 "액션"으로 변경
		 else
			 b.setText("Action");		// 버튼의 문자열을 "Action"으로 변경
	 }
 }
 