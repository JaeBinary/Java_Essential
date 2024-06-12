/*
 * 일자 : 24.05.17 (10week)
 * 범위 : Chapter 8. 자바 GUI 스윙 기초
 * 예제 : 8-6. 배치관리자 없는 컨테이너에 컴포넌트를 절대 위치와 절대 크기로 지정
 */

 package chapter08.example.ex06;				// chapter8 패키지에 속하는 클래스임을 명시
 import javax.swing.*;			// 자바 스윙 라이브러리의 모든 클래스를 임포트
 import java.awt.*;				// 자바 AWT 라이브러리의 모든 클래스를 임포트
 
 /* NullContainerEx 클래스는 JFrame 클래스를 상속받음 */
 public class NullContainerEx extends JFrame {
	 /* NullContainerEx 클래스의 생성자 정의 */
	 public NullContainerEx() {
		 setTitle("배치관리자 없이 절대 위치에 배치하는 예제");	  // 프레임의 제목을 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// 프레임의 닫기 버튼을 클릭하면 프로그램 종료
		 Container contentPane = getContentPane();					// 컨텐트팬(contentPane) 알아내기
 
		 contentPane.setLayout(null);	// 컨텐트팬의 레이아웃 매니저를 제거
		 
		 // JLabel 컴포넌트 생성하고 직접 위치와 크기를 지정한다.
		 JLabel la = new JLabel("Hello, Press Buttons!");	// 레이블 생성
		 la.setLocation(130, 50);							// 레이블의 위치를 (130, 50)으로 설정
		 la.setSize(200, 20);						// 레이블의 크기를 200x20으로 설정 
		 contentPane.add(la);									// 레이블을 컨텐트 팬에 부착
		 
		 // 9개의 버튼 컴퍼넌트를 생성하고 동일한 크기로 설정한다.
		 // 위치는 서로 겹치게 설정한다.
		 for(int i=1; i<=9; i++) {
			 JButton b = new JButton(Integer.toString(i));		// 버튼 생성
			 b.setLocation(i*15, i*15);							// 버튼의 위치를 설정
			 b.setSize(50, 20);					// 버튼의 크기를 동일하게 50x20으로 설정
			 contentPane.add(b);								// 버튼을 컨텐트 팬에 부착
		 }
		 
		 setSize(300, 200);	// 프레임의 크기를 너비 300, 높이 200으로 설정
		 setVisible(true);				// 프레임을 화면에 보이도록 설정
	 }
 
	 /* main 메서드: 자바 애플리케이션의 시작점 */
	 public static void main(String[] args) {
		 new NullContainerEx();		// NullContainerEx 객체를 생성하여 프레임을 화면에 표시
	 }
 }
 