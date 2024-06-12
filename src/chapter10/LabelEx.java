/*
 * 일자 : 24.05.31 (12week)
 * 범위 : Chapter 10. 스윙 컴포넌트 활용
 * 예제 : 10-2. JLabel 이용 문자열과 이미지 출력
 */

 package chapter10; 				// chapter10 패키지에 속하는 클래스임을 명시
 import java.awt.*; 				// AWT 패키지 임포트
 import javax.swing.*; 				// 스윙 패키지 임포트
 
 public class LabelEx extends JFrame {  // LabelEx 클래스는 JFrame을 상속받음
	 public LabelEx() {
		 setTitle("레이블 예제");          			  // 프레임의 제목 설정
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  	// 창을 닫을 때 프로그램 종료 설정
		 Container c = getContentPane();                   	// 컨텐트 팬을 가져옴
		 c.setLayout(new FlowLayout());                    	// 컨텐트 팬의 레이아웃을 FlowLayout으로 설정
 
		 // 문자열 레이블 생성
		 JLabel textLabel = new JLabel("제임스 고슬링 입니더!");  	// "제임스 고슬링 입니더!" 문자열을 가진 레이블 생성
 
		 // 이미지 레이블 생성
		 ImageIcon img = new ImageIcon("images/10-2/gosling.jpg");  	// 이미지 파일 로딩
		 JLabel imageLabel = new JLabel(img);                  				// 이미지를 가진 레이블 생성
 
		 // 문자열과 이미지를 모두 가진 레이블 생성
		 ImageIcon icon = new ImageIcon("images/10-2/icon.gif");    							// 아이콘 이미지 파일 로딩
		 JLabel label = new JLabel("커피한잔 하실래예, 전화주이소", icon, SwingConstants.CENTER);	// 문자열과 아이콘을 가진 레이블 생성
 
		 // 컨텐트 팬에 3개의 레이블 삽입
		 c.add(textLabel);  				// 문자열 레이블 추가
		 c.add(imageLabel); 				// 이미지 레이블 추가
		 c.add(label);      				// 문자열과 이미지를 가진 레이블 추가
 
		 setSize(300, 500);  	// 프레임 크기 설정
		 setVisible(true);   				// 프레임을 화면에 표시
	 }
 
	 public static void main(String[] args) {
		 new LabelEx();  	// LabelEx 객체 생성 및 실행
	 }
 }
 