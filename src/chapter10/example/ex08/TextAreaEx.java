/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-8. JTextArea로 여러 줄이 입력되는 창 만들기
 */

 package chapter10.example.ex08;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;          // AWT 이벤트 패키지 임포트
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class TextAreaEx extends JFrame {
	 private JTextField tf = new JTextField(20); 			// 열 개수가 20인 텍스트필드 생성
	 private JTextArea ta = new JTextArea(7, 20); 		// 7줄, 한 줄에 20개의 문자 입력 가능한 텍스트영역 생성
 
	 public TextAreaEx() {
		 setTitle("텍스트영역 만들기 예제"); 				// 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	 // 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 					 // 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 					 // 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 c.add(new JLabel("입력 후 <Enter> 키를 입력하세요")); 	// 라벨 추가
		 c.add(tf); 												 // 텍스트필드 추가
		 c.add(new JScrollPane(ta)); 								 // 스크롤 가능한 텍스트영역 추가
 
		 // 텍스트필드에 Action 리스너 등록
		 tf.addActionListener(new ActionListener() { 	// <Enter> 키 입력 시 작동하는 리스너
			 public void actionPerformed(ActionEvent e) {
				 JTextField t = (JTextField) e.getSource(); 	// 이벤트가 발생한 텍스트필드를 가져옴
				 ta.append(t.getText() + "\n"); 				// 텍스트필드의 내용을 텍스트영역에 추가
				 t.setText(""); 								// 텍스트필드 내용 지우기
			 }
		 });
 
		 setSize(300, 250); 	// 프레임 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new TextAreaEx(); 	// TextAreaEx 객체 생성 및 실행
	 }
 }
 