/*
 * 일자 : 24.06.07 (13week)
 * 범위 : Chapter 12. 자바 스레드 기초
 * 예제 : 12-6. wait(), notify()를 이용한 바 채우기
 */
 
 package chapter12.example.ex06;                // chapter12 패키지에 속하는 클래스임을 명시
 import java.awt.*; 			   // AWT 패키지를 가져옴
 import java.awt.event.*; 		   // AWT 이벤트 관련 패키지를 가져옴
 import javax.swing.*; 			   // Swing 패키지를 가져옴
 
 class MyLabel extends JLabel { 		// 바를 나타내는 커스텀 레이블 클래스 정의
	 private int barSize = 0; 			// 바의 크기를 저장할 변수
	 private int maxBarSize; 			// 최대 바의 크기를 저장할 변수
 
	 public MyLabel(int maxBarSize) { 	// 생성자, 최대 바의 크기를 설정함
		 this.maxBarSize = maxBarSize;
	 }
 
	 public void paintComponent(Graphics g) { 									// 바를 그리는 메서드
		 super.paintComponent(g);
		 g.setColor(Color.MAGENTA);
		 int width = (int) (((double)(getWidth())) / maxBarSize * barSize); 	// 바의 길이 계산
		 if (width == 0) return; 												// 바의 크기가 0이면 그리지 않음
		 g.fillRect(0, 0, width, this.getHeight()); 						// 바를 그림
	 }
 
	 synchronized void fill() { 			// 바를 채우는 메서드
		 if (barSize == maxBarSize) { 		// 바가 꽉 찼으면
			 try {
				 wait(); 					// ConsumerThread에 의해 바의 크기가 줄어들 때까지 대기
			 } catch (InterruptedException e) {
				 return;
			 }
		 }
		 barSize++; 						// 바의 크기를 1 증가시킴
		 repaint(); 						// 바를 다시 그림
		 notify(); 							// 대기 중인 ConsumerThread 스레드를 깨움
	 }
 
	 synchronized void consume() { 			// 바를 소모하는 메서드
		 if (barSize == 0) { 				// 바가 비어있으면
			 try {
				 wait(); 					// 바의 크기가 0보다 커질 때까지 대기
			 } catch (InterruptedException e) {
				 return;
			 }
		 }
		 barSize--; 						// 바의 크기를 1 감소시킴
		 repaint(); 						// 바를 다시 그림
		 notify(); 							// 대기 중인 이벤트 스레드를 깨움
	 }
 }
 
 class ConsumerThread extends Thread { 		// 소비자 스레드 클래스 정의
	 private MyLabel bar; 					// 바를 나타내는 MyLabel 객체
 
	 public ConsumerThread(MyLabel bar) { 	// 생성자, 바를 받아서 저장함
		 this.bar = bar;
	 }
 
	 @Override
	 public void run() { 					// 스레드 실행 메서드
		 while (true) { 					// 무한 반복
			 try {
				 sleep(100); 		// 0.1초마다 실행
				 bar.consume();				// 바를 1씩 줄임
			 } catch (InterruptedException e) {
				 return;
			 }
		 }
	 }
 }
 
 public class TabAndThreadEx extends JFrame { 					// 메인 프레임 클래스 정의
	 private MyLabel bar = new MyLabel(100); 		// 최대 바의 크기가 100인 MyLabel 객체 생성
 
	 public TabAndThreadEx(String title) { 						// 생성자, 프레임 타이틀을 받아서 설정함
		 super(title);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		// 프로그램 종료 설정
		 Container c = getContentPane(); 						// 컨텐트 팬 가져오기
		 c.setLayout(null); 								// 레이아웃 설정하지 않음
		 bar.setBackground(Color.ORANGE); 						// 바의 배경색 설정
		 bar.setOpaque(true); 							// 투명도 설정
		 bar.setLocation(20, 50); 							// 위치 설정
		 bar.setSize(300, 20); 					// 크기 설정
		 c.add(bar); 											// 컨텐트 팬에 바 추가
 
		 c.addKeyListener(new KeyAdapter() { 					// 키 이벤트 리스너 추가
			 public void keyPressed(KeyEvent e) { 				// 키 누름 이벤트 처리
				 bar.fill(); 									// 바를 1씩 채움
			 }
		 });
		 setSize(350, 200); 						// 프레임 크기 설정
		 setVisible(true); 									// 프레임 보이기
 
		 c.setFocusable(true); 						// 컨텐트 팬이 포커스를 받을 수 있도록 설정
		 c.requestFocus(); 										// 컨텐트 팬에 포커스 설정
		 ConsumerThread th = new ConsumerThread(bar); 			// 소비자 스레드 생성
		 th.start(); 											// 소비자 스레드 시작
	 }
 
	 public static void main(String[] args) {
		 new TabAndThreadEx("아무키나 빨리 눌러 바 채우기"); 	// TabAndThreadEx 객체 생성
	 }
 }
