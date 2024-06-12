/*
 * 일자 : 24.05.17 (10week)
 * 범위 : Chapter 8. 자바 GUI 스윙 기초
 * 예제 : 8-3. FlowLayout 배치관리자 활용
 */

 package chapter08.example.ex03; 			// chapter8 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 			// 자바 스윙 라이브러리의 모든 클래스를 임포트
 import java.awt.*; 			// 자바 AWT 라이브러리의 모든 클래스를 임포트
 
 /* FlowLayoutEx 클래스는 JFrame 클래스를 상속받음 */
 public class FlowLayoutEx extends JFrame {
	 /* FlowLayoutEx 클래스의 생성자 정의 */
	 public FlowLayoutEx() {
		 setTitle("FlowLayout 예제"); 				 // 프레임의 제목을 "FlowLayout 예제"로 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	// 프레임의 닫기 버튼을 클릭하면 프로그램 종료
 
		 // 컨텐트팬(contentPane) 객체를 가져옴
		 Container contentPane = getContentPane();
		 
		 // FlowLayout을 왼쪽 정렬로, 수평 간격 30 픽셀, 수직 간격 40 픽셀로 설정
		 contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		 
		 // 컨텐트팬에 "add" 버튼 추가
		 contentPane.add(new JButton("add"));
		 // 컨텐트팬에 "sub" 버튼 추가
		 contentPane.add(new JButton("sub"));
		 // 컨텐트팬에 "mul" 버튼 추가
		 contentPane.add(new JButton("mul"));
		 // 컨텐트팬에 "div" 버튼 추가
		 contentPane.add(new JButton("div"));
		 // 컨텐트팬에 "Calculate" 버튼 추가
		 contentPane.add(new JButton("Calculate"));
 
		 setSize(300, 200); 	// 프레임의 크기를 너비 300, 높이 200으로 설정
		 setVisible(true); 				// 프레임을 화면에 보이도록 설정
	 }
 
	 /* main 메서드: 자바 애플리케이션의 시작점 */
	 public static void main(String[] args) {
		 new FlowLayoutEx();	// FlowLayoutEx 객체를 생성하여 프레임을 화면에 표시
	 }
 }
 