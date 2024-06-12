/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-6. JRadioButton으로 라디오버튼 만들기
 */

 package chapter10;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class RadioButtonEx extends JFrame {
	 public RadioButtonEx() {
		 setTitle("라디오버튼 만들기 예제"); 				   // 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 						// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 						// 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 ButtonGroup g = new ButtonGroup(); 					// 버튼 그룹 객체 생성
		 
		 // 라디오버튼 3개 생성
		 JRadioButton apple = new JRadioButton("사과");
		 JRadioButton pear = new JRadioButton("배", true); 	// 기본 선택된 버튼
		 JRadioButton cherry = new JRadioButton("체리");
		 
		 // 버튼 그룹에 3개의 라디오버튼 삽입
		 g.add(apple);
		 g.add(pear);
		 g.add(cherry);
 
		 // 컨텐트 팬에 3개의 라디오버튼 삽입
		 c.add(apple); 
		 c.add(pear); 
		 c.add(cherry);
 
		 setSize(250, 150); 	// 프레임 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new RadioButtonEx(); 	// RadioButtonEx 객체 생성 및 실행
	 }
 }
 