/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-9. JList<E>로 다양한 리스트 만들기
 */

 package chapter10;                // chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*;                // AWT 패키지 임포트
 import javax.swing.*;			   // 스윙 패키지 임포트
 
 public class ListEx extends JFrame {
	 private String[] fruits = {"apple", "banana", "kiwi", "mango",
			 "pear", "peach", "berry", "strawberry", "blackberry"};
	 private ImageIcon[] images = {new ImageIcon("images/icon1.png"),
			 new ImageIcon("images/10-9/icon2.png"),
			 new ImageIcon("images/10-9/icon3.png"),
			 new ImageIcon("images/10-9/icon4.png")};
 
	 public ListEx() {
		 setTitle("리스트 만들기 예제"); 					  // 프레임 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane(); 						// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout()); 						// 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 JList<String> strList = new JList<String>(fruits); 	// 문자열 리스트 생성
		 c.add(strList); 										// 문자열 리스트를 컨텐트 팬에 추가
 
		 JList<ImageIcon> imageList = new JList<ImageIcon>(); 	// 이미지 리스트 생성
		 imageList.setListData(images); 						// 이미지 리스트 데이터 설정
		 c.add(imageList); 										// 이미지 리스트를 컨텐트 팬에 추가
 
		 JList<String> scrollList = new JList<String>(fruits); 	// 문자열 리스트 생성
		 c.add(new JScrollPane(scrollList)); 					// 리스트를 JScrollPane에 부착하여 스크롤 가능하도록 함
 
		 setSize(300, 300); 						// 프레임 크기 설정
		 setVisible(true); 									// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new ListEx(); 	// ListEx 객체 생성 및 실행
	 }
 }
 