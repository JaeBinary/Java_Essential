/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-10. JComboBox<E>로 콤보박스 만들고 활용하기
 */

 package chapter10.example.ex10;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;          // AWT 이벤트 패키지 임포트
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class ComboActionEx extends JFrame {
	 private String[] fruits = {"apple", "banana", "mango"}; 							// 콤보박스의 아이템으로 사용할 문자열 배열
	 private ImageIcon[] images = {new ImageIcon("images/10-10/apple.jpg"), 	
							 new ImageIcon("images/10-10/banana.jpg"), 
							 new ImageIcon("images/10-10/mango.jpg")}; 		// 이미지 아이콘 배열
	 private JLabel imgLabel = new JLabel(images[0]); 									// 첫 번째 이미지를 출력할 레이블
	 
	 public ComboActionEx() {
		 setTitle("콤보박스 활용 예제"); 		// 프레임의 제목 설정
		 Container c = getContentPane(); 		 // 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 		 // 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 JComboBox<String> combo = new JComboBox<String>(fruits); 	// 콤보박스 생성 및 아이템 설정
		 c.add(combo); 												// 콤보박스를 컨텐트 팬에 추가
		 c.add(imgLabel); 											// 이미지를 출력할 레이블을 컨텐트 팬에 추가
 
		 // 콤보박스에 액션 리스너 등록. 선택된 아이템의 이미지를 출력
		 combo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 JComboBox<String> cb = (JComboBox<String>) e.getSource(); 	// 액션 이벤트가 발생한 콤보박스를 알아냄
				 int index = cb.getSelectedIndex(); 						// 콤보박스에서 선택된 아이템의 인덱스 번호를 알아냄
				 imgLabel.setIcon(images[index]); 							// 선택된 인덱스에 해당하는 이미지를 이미지 레이블에 출력
			 }
		 });
		 
		 setSize(300, 250); 	// 프레임의 크기 설정
		 setVisible(true); 				// 프레임을 화면에 표시
	 }
	 
	 public static void main(String[] args) {
		 new ComboActionEx(); 	// ComboActionEx 객체를 생성하여 프레임을 실행
	 }
 }
 