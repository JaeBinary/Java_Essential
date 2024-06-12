/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-11. 메뉴 만들기
 */

 package chapter10;                // chapter10 패키지에 속하는 클래스임을 명시
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class MenuEx extends JFrame {
	 public MenuEx() {
		 setTitle("Menu 만들기 예제"); 	  // 프레임의 제목 설정
		 createMenu(); 							// 메뉴를 생성하여 프레임에 삽입
		 setSize(250, 200); 		// 프레임의 크기 설정
		 setVisible(true); 					// 프레임을 화면에 표시
	 }
	 
	 // 메뉴를 만들어 프레임에 삽입하는 메소드
	 private void createMenu() {
		 JMenuBar mb = new JMenuBar(); 					// 메뉴바 생성
		 JMenu screenMenu = new JMenu("Screen"); 		// Screen 메뉴 생성
 
		 // Screen 메뉴에 메뉴아이템 생성 삽입
		 screenMenu.add(new JMenuItem("Load")); 		// Load 메뉴 아이템 추가
		 screenMenu.add(new JMenuItem("Hide")); 		// Hide 메뉴 아이템 추가
		 screenMenu.add(new JMenuItem("ReShow")); 		// ReShow 메뉴 아이템 추가
		 screenMenu.addSeparator(); // 분리선 삽입
		 screenMenu.add(new JMenuItem("Exit")); // Exit 메뉴 아이템 추가
 
		 // 메뉴바에 메뉴 삽입
		 mb.add(screenMenu); 				// Screen 메뉴 삽입
		 mb.add(new JMenu("Edit")); 		// Edit 메뉴 생성 삽입
		 mb.add(new JMenu("Source")); 	// Source 메뉴 생성 삽입
		 mb.add(new JMenu("Project")); 	// Project 메뉴 생성 삽입
		 mb.add(new JMenu("Run")); 		// Run 메뉴 생성 삽입
 
		 // 메뉴바를 프레임에 부착
		 setJMenuBar(mb);
	 }
	 
	 public static void main(String[] args) {
		 new MenuEx(); 	// MenuEx 객체를 생성하여 프레임을 실행
	 }
 }
 