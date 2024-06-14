/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-12. 메뉴에 Action 리스너 활용
 */

 package chapter10.example.ex12;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;          // AWT 이벤트 패키지 임포트
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class MenuActionEventEx extends JFrame {
	 private JLabel imgLabel = new JLabel(); 	// 빈 이미지를 가진 레이블
 
	 public MenuActionEventEx() {
		 setTitle("Menu에 Action 리스너 만들기 예제"); 		   // 프레임의 제목 설정
		 createMenu(); 												// 메뉴를 생성하고 프레임에 삽입
		 getContentPane().add(imgLabel, BorderLayout.CENTER); 		// 프레임의 중앙에 이미지 레이블 추가
		 setSize(250, 200); 							// 프레임의 크기 설정
		 setVisible(true); 										// 프레임을 화면에 표시
	 }
 
	 private void createMenu() {
		 JMenuBar mb = new JMenuBar(); 									// 메뉴바 생성
		 JMenuItem[] menuItem = new JMenuItem[4]; 						// 메뉴아이템 배열 생성
		 String[] itemTitle = { "Load", "Hide", "ReShow", "Exit" }; 	// 메뉴아이템의 제목 배열
		 JMenu screenMenu = new JMenu("Screen"); 						// Screen 메뉴 생성
 
		 // 4개의 메뉴아이템을 Screen 메뉴에 삽입
		 MenuActionListener listener = new MenuActionListener(); 		// Action 리스너 생성
		 for (int i = 0; i < menuItem.length; i++) {
			 menuItem[i] = new JMenuItem(itemTitle[i]); 				// 메뉴아이템 생성
			 menuItem[i].addActionListener(listener); 					// 메뉴아이템에 Action 리스너 등록
			 screenMenu.add(menuItem[i]); 								// 메뉴아이템을 Screen 메뉴에 삽입
		 }
 
		 mb.add(screenMenu); 	// 메뉴바에 Screen 메뉴 삽입
		 setJMenuBar(mb); 		// 메뉴바를 프레임에 부착
	 }
 
	 class MenuActionListener implements ActionListener { 	// 메뉴아이템 처리 Action 리스너
		 public void actionPerformed(ActionEvent e) {
			 String cmd = e.getActionCommand(); 	// 사용자가 선택한 메뉴아이템의 문자열 리턴
			 switch (cmd) { 	// 메뉴 아이템의 종류 구분
				 case "Load":
					 if (imgLabel.getIcon() != null) return; 	// 이미 로딩되었으면 리턴
					 imgLabel.setIcon(new ImageIcon("images/10-12/img.jpg")); 		// 이미지 로드
					 break;
				 case "Hide":
					 imgLabel.setVisible(false); 										// 이미지 숨기기
					 break;
				 case "ReShow":
					 imgLabel.setVisible(true); 										// 이미지 다시 보여주기
					 break;
				 case "Exit":
					 System.exit(0); 												// 프로그램 종료
					 break;
			 }
		 }
	 }
 
	 public static void main(String[] args) {
		 new MenuActionEventEx(); 	// MenuActionEventEx 객체를 생성하여 프레임을 실행
	 }
 }
 