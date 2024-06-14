/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-7. JTextField로 텍스트필드 만들기
 */

 package chapter10.example.ex07;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class TextFieldEx extends JFrame {
	 public TextFieldEx() {
		 setTitle("텍스트필드 만들기 예제"); 				   // 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 						// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 						// 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 // 라벨과 텍스트필드 추가
		 c.add(new JLabel("이름  ")); 							   // "이름" 라벨 추가
		 c.add(new JTextField(20)); 					      // 열 개수가 20인 텍스트필드 추가
		 c.add(new JLabel("학과  ")); 							   // "학과" 라벨 추가
		 c.add(new JTextField("컴퓨터공학과", 20)); 		// 기본 텍스트가 "컴퓨터공학과"이고 열 개수가 20인 텍스트필드 추가
		 c.add(new JLabel("주소  ")); // "주소" 라벨 추가
		 c.add(new JTextField("서울시 ...", 20)); 		   // 기본 텍스트가 "서울시 ..."이고 열 개수가 20인 텍스트필드 추가
 
		 setSize(250, 150); 							  // 프레임 크기 설정
		 setVisible(true); 										  // 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new TextFieldEx(); 	// TextFieldEx 객체 생성 및 실행
	 }
 }
 