/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-3. JButton에 이미지 사용 예제
 */

 package chapter10.example.ex03;                	// chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*;                	// AWT 패키지 임포트
 import javax.swing.*;             	// 스윙 패키지 임포트
 
 public class ButtonImageEx extends JFrame { 	// ButtonImageEx 클래스는 JFrame을 상속받음
	 public ButtonImageEx() {
		 setTitle("이미지 버튼 예제");           			// 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	 // 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane();                	 // 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout());                  	 // 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 // 3개의 이미지를 읽어들인다.
		 ImageIcon normalIcon = new ImageIcon("images/10-3/normalIcon.gif");  			// 기본 아이콘 이미지 로드
		 ImageIcon rolloverIcon = new ImageIcon("images/10-3/pressedIcon.gif");  		// 롤오버 아이콘 이미지 로드
		 ImageIcon pressedIcon = new ImageIcon("images/10-3/rolloverIcon.gif");  		// 눌림 아이콘 이미지 로드
		 
		 // 3개의 아이콘을 가진 버튼 컴포넌트 생성
		 JButton btn = new JButton("call~~", normalIcon);  	// 기본 아이콘과 텍스트를 가진 버튼 생성
		 btn.setPressedIcon(pressedIcon);  							// 버튼이 눌렸을 때의 아이콘 설정
		 btn.setRolloverIcon(rolloverIcon);  						// 버튼에 마우스를 올렸을 때의 아이콘 설정
		 c.add(btn);  												// 버튼을 컨텐트 팬에 추가
		 
		 setSize(250, 150);  	// 프레임 크기 설정
		 setVisible(true);   				// 프레임을 화면에 표시
	 }
	 
	 public static void main(String[] args) {
		 new ButtonImageEx();  	// ButtonImageEx 객체 생성 및 실행
	 }
 }
 