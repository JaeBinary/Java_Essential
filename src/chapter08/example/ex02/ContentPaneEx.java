/*
 * 일자 : 24.05.17 (10week)
 * 범위 : Chapter 8. 자바 GUI 스윙 기초
 * 예제 : 8-2. 3개의 버튼 컴포넌트를 가진 스윙 프레임 만들기
 */

 package chapter08.example.ex02; 			// chapter8 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 			// 자바 스윙 라이브러리의 모든 클래스를 임포트
 import java.awt.*; 			// 자바 AWT 라이브러리의 모든 클래스를 임포트
 
 /* ContentPaneEx 클래스는 JFrame 클래스를 상속받음 */
 public class ContentPaneEx extends JFrame {
	 /* ContentPaneEx 클래스의 생성자 정의 */ 
	 public ContentPaneEx() {
		 setTitle("ContentPane과 JFrame 예제"); 		// 프레임의 제목을 "ContentPane과 JFrame 예제"로 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 프레임의 닫기 버튼을 클릭하면 프로그램 종료
 
		 // 컨텐트팬(contentPane) 객체를 가져옴
		 Container contentPane = getContentPane();
		 contentPane.setBackground(Color.ORANGE);	// 컨텐트팬의 배경색을 오렌지색으로 설정
		 contentPane.setLayout(new FlowLayout());	// 컨텐트팬의 레이아웃 매니저를 FlowLayout으로 설정
 
		 // 컨텐트팬에 "OK" 버튼 추가
		 contentPane.add(new JButton("OK"));
		 // 컨텐트팬에 "Cancel" 버튼 추가
		 contentPane.add(new JButton("Cancel"));
		 // 컨텐트팬에 "Ignore" 버튼 추가
		 contentPane.add(new JButton("Ignore"));
		 
		 setSize(300, 150); 	// 프레임의 크기를 너비 300, 높이 150으로 설정
		 setVisible(true); 				// 프레임을 화면에 보이도록 설정
	 }
	 
	 /* main 메서드: 자바 애플리케이션의 시작점 */
	 public static void main(String[] args) {
		 new ContentPaneEx(); // ContentPaneEx 객체를 생성하여 프레임을 화면에 표시
	 }
 }
 