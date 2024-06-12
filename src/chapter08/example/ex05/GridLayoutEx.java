/*
 * 일자 : 24.05.17 (10week)
 * 범위 : Chapter 8. 자바 GUI 스윙 기초
 * 예제 : 8-5. GridLayout 배치관리자를 사용하는 예
 */

 package chapter08.example.ex05;				// chapter8 패키지에 속하는 클래스임을 명시
 import javax.swing.*;			// 자바 스윙 라이브러리의 모든 클래스를 임포트
 import java.awt.*;				// 자바 AWT 라이브러리의 모든 클래스를 임포트
 
 /* GridLayoutEx 클래스는 JFrame 클래스를 상속받음 */
 public class GridLayoutEx extends JFrame {
	 /* GridLayoutEx 클래스의 생성자 정의 */
	 public GridLayoutEx() {
		 super("GridLayout 예제");					 // 부모 클래스의 생성자 호출하여 프레임의 제목을 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 프레임의 닫기 버튼을 클릭하면 프로그램 종료
		 
		 // 컨텐트팬(contentPane) 객체를 가져옴
		 Container contentPane = getContentPane();
		 
		 contentPane.setLayout(new GridLayout(1, 10));	// 1x10의 GridLayout 배치관리자 설정
		 
		 // 10개의 버튼을 추가
		 for(int i = 0; i < 10; i++) { 
			  String text = Integer.toString(i);	// 정수 i를 문자열로 변환
			 JButton button = new JButton(text);	// 버튼 컴포넌트 생성
			 contentPane.add(button);				// 컨텐트팬에 버튼 추가
		 }
		 
		 setSize(500, 200);	// 프레임의 크기를 너비 500, 높이 200으로 설정
		 setVisible(true);				// 프레임을 화면에 보이도록 설정
	 }
 
	 /* main 메서드: 자바 애플리케이션의 시작점 */
	 public static void main(String[] args) {
		 new GridLayoutEx();	// GridLayoutEx 객체를 생성하여 프레임을 화면에 표시
	 }
 }
 