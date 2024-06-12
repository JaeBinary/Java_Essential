/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-5. ItemEvent를 활용하여 체크박스로 가격 합산 응용
 */

 package chapter10;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.event.*;          // AWT 이벤트 패키지 임포트
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;             // 스윙 패키지 임포트
 
 public class CheckBoxItemEventEx extends JFrame {
	 private JCheckBox[] fruits = new JCheckBox[3]; 		// 체크박스 배열
	 private String[] names = {"사과", "배", "체리"}; 		  // 체크박스 문자열로 사용할 문자열 배열
	 private JLabel sumLabel; 								// 계산 합을 출력할 레이블
	 
	 public CheckBoxItemEventEx() {
		 setTitle("체크박스와 ItemEvent 예제"); 			// 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	  // 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 					  // 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 					  // 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 c.add(new JLabel("사과 100원, 배 500원, 체리 20000원")); 	// 가격 안내 레이블 추가
		 
		 // 3개의 체크박스 컴포넌트를 생성하고 컨텐트팬에 삽입, Item 리스너 등록
		 MyItemListener listener = new MyItemListener();
		 for(int i = 0; i < fruits.length; i++) {
			 fruits[i] = new JCheckBox(names[i]); 		// names[]의 문자열로 체크박스 생성
			 fruits[i].setBorderPainted(true); 		// 체크박스의 외곽선이 보이도록 설정
			 c.add(fruits[i]); 							// 컨텐트 팬에 체크박스 삽입
			 fruits[i].addItemListener(listener); 		// 체크박스에 Item 리스너 등록
		 }
		 
		 sumLabel = new JLabel("현재 0원 입니다."); 	// 가격 합을 출력하는 레이블 생성
		 c.add(sumLabel); 								  // 컨텐트 팬에 레이블 삽입
		 
		 setSize(250, 200); 		// 프레임 크기 설정
		 setVisible(true); 					// 프레임을 화면에 표시
	 }
	 
	 // Item 리스너 구현
	 class MyItemListener implements ItemListener {
		 private int sum = 0; 	// 가격의 합
		 
		 // 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
		 public void itemStateChanged(ItemEvent e) {
			 if(e.getStateChange() == ItemEvent.SELECTED) { 	// 체크박스가 선택된 경우
				 if(e.getItem() == fruits[0]) 			// 사과 체크박스 
					 sum += 100;
				 else if(e.getItem() == fruits[1]) 		// 배 체크박스
					 sum += 500;
				 else // 체리 체크박스
					 sum += 20000;
			 }
			 else { // 체크박스가 해제된 경우
				 if(e.getItem() == fruits[0]) 			// 사과 체크박스 
					 sum -= 100;
				 else if(e.getItem() == fruits[1]) 		// 배 체크박스
					 sum -= 500;
				 else // 체리 체크박스
					 sum -= 20000;				
			 }
			 sumLabel.setText("현재 " + sum + "원 입니다."); 	// 합 출력
		 }
	 }
 
	 public static void main(String[] args) {
		 new CheckBoxItemEventEx(); 	// CheckBoxItemEventEx 객체 생성 및 실행
	 }
 }
 