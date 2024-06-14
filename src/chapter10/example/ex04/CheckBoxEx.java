/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-4. JCheckBox로 체크박스 만들기
 */

 package chapter10.example.ex04;                	// chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*;                	// AWT 패키지 임포트
 import javax.swing.*;             	// 스윙 패키지 임포트
 
 public class CheckBoxEx extends JFrame {  // CheckBoxEx 클래스는 JFrame을 상속받음
	 public CheckBoxEx() {
		 setTitle("체크박스 만들기 예제");          		// 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	// 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane();                 	// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout());                  	// 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 // 3개의 체크박스를 생성
		 JCheckBox apple = new JCheckBox("사과");        			// "사과" 체크박스 생성
		 JCheckBox pear = new JCheckBox("배", true);     	// "배" 체크박스 생성, 기본적으로 선택됨
		 JCheckBox cherry = new JCheckBox("체리");       			// "체리" 체크박스 생성
 
		 // 컨텐트 팬에 3개의 체크박스를 추가
		 c.add(apple);
		 c.add(pear);
		 c.add(cherry);
 
		 setSize(250, 150);  	// 프레임 크기 설정
		 setVisible(true);   				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new CheckBoxEx();  	// CheckBoxEx 객체 생성 및 실행
	 }
 }
 