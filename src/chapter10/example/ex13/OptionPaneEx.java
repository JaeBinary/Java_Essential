/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-13. JOptionPane으로 3가지 팝업 다이얼로그 만들기
 */

 package chapter10.example.ex13;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;          // AWT 이벤트 패키지 임포트
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class OptionPaneEx extends JFrame {
	 public OptionPaneEx() {
		 setTitle("옵션 팬 예제"); 							  	  // 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 				// 프레임 닫기 버튼 클릭 시 프로그램 종료
		 Container c = getContentPane(); 								// 컨텐트 팬을 가져옴
		 setSize(500, 200); 								// 프레임의 크기 설정
		 c.add(new MyPanel(), BorderLayout.NORTH); 						// 프레임의 북쪽에 MyPanel 추가
		 setVisible(true); 											// 프레임을 화면에 표시
	 }
	 
	 class MyPanel extends Panel {
		 private JButton inputBtn = new JButton("Input Name"); 	// "Input Name" 버튼 생성
		 private JTextField tf = new JTextField(10); 			// 길이 10의 텍스트 필드 생성
		 private JButton confirmBtn = new JButton("Confirm"); 		// "Confirm" 버튼 생성
		 private JButton messageBtn = new JButton("Message"); 		// "Message" 버튼 생성
		 
		 public MyPanel() {
			 setBackground(Color.LIGHT_GRAY); 	// 패널의 배경색을 밝은 회색으로 설정
			 add(inputBtn); 					// 패널에 inputBtn 추가
			 add(confirmBtn); 					// 패널에 confirmBtn 추가
			 add(messageBtn); 					// 패널에 messageBtn 추가
			 add(tf); 							// 패널에 텍스트 필드 추가
			 
			 // inputBtn 버튼에 Action 리스너 등록
			 inputBtn.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 // 입력 다이얼로그 생성
					 String name = JOptionPane.showInputDialog("이름을 입력하세요.");
					 if (name != null)
						 tf.setText(name); 	// 사용자가 입력한 문자열을 텍스트 필드에 출력
				 }
			 });

			 // confirmBtn 버튼에 Action 리스너 등록
			 confirmBtn.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 // 확인 다이얼로그 생성
					 int result = JOptionPane.showConfirmDialog(null, 
							 "계속할 것입니까?", "Confirm", JOptionPane.YES_NO_OPTION);
					 
					 // 사용자가 선택한 버튼에 따라 문자열을 텍스트 필드에 출력
					 if (result == JOptionPane.CLOSED_OPTION)
						 tf.setText("Just Closed without Selection");
					 else if (result == JOptionPane.YES_OPTION)
						 tf.setText("Yes");
					 else
						 tf.setText("No");
				 }
			 });
			 
			 // messageBtn 버튼에 Action 리스너 등록
			 messageBtn.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent e) {
					 // 메시지 다이얼로그 생성
					 JOptionPane.showMessageDialog(null, "조심하세요", "Message", JOptionPane.ERROR_MESSAGE);
				 }
			 });
		 }
	 }
 
	 public static void main(String[] args) {
		 new OptionPaneEx(); // OptionPaneEx 객체 생성하여 프레임 실행
	 }
 }
 