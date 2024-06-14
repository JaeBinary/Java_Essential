package chapter10.practice.pr08;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TenLabelsFrame extends JFrame {
	private JLabel [] gameLabels = new JLabel [10]; // 레이블 배열 선언
	private int nextPressed = 0; // 다음 클릭할 숫자를 나타내는 변수
	
	public TenLabelsFrame() {
		super("Ten 레이블 클릭"); // 프레임 제목 설정
		setLayout(null); // 레이아웃 매니저를 null로 설정하여 절대 위치로 컴포넌트 배치
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
		
		// 레이블 배열 초기화 및 설정
		for(int i=0; i<gameLabels.length; i++) {
			Container c = getContentPane(); // 컨텐트 팬 가져오기
			gameLabels[i] = new JLabel(Integer.toString(i)); // 레이블 생성하여 숫자 설정
			gameLabels[i].setForeground(Color.MAGENTA); // 레이블의 전경색 설정
			c.add(gameLabels[i]); // 레이블을 컨텐트 팬에 추가
			gameLabels[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JLabel la = (JLabel)e.getSource(); // 이벤트가 발생한 레이블 가져오기
					if(Integer.parseInt(la.getText()) == nextPressed) { // 클릭한 숫자가 다음 순서인지 확인
						nextPressed++; // 다음 숫자로 이동
						if(nextPressed == 10) { // 모든 숫자를 클릭했으면
							nextPressed = 0; // 다시 처음부터 시작
							configure(); // 레이블 재배치
						} else {
							la.setVisible(false); // 클릭한 레이블 숨기기
						}
					}
				}
			});
		}
		
		setSize(300,300); // 프레임 크기 설정
		setVisible(true); // 프레임을 화면에 표시
		configure(); // 초기 레이블 배치 설정
	}
	
	// 레이블을 랜덤 위치에 재배치하는 메서드
	private void configure() {
		Container c = getContentPane(); // 컨텐트 팬 가져오기
		for(int i=0; i<gameLabels.length; i++) {
			int xBound = c.getWidth() - gameLabels[i].getWidth(); // x 경계값 계산
			int yBound = c.getHeight() - gameLabels[i].getHeight(); // y 경계값 계산				
			int x = (int)(Math.random()*xBound); // 레이블의 x 좌표 설정
			int y = (int)(Math.random()*yBound); // 레이블의 y 좌표 설정				
			gameLabels[i].setLocation(x, y); // 레이블 위치 설정
			gameLabels[i].setSize(15, 15); // 레이블 크기 설정
			gameLabels[i].setVisible(true); // 레이블을 보이도록 설정
		}
	}
	
	// 메인 메서드
	static public void main(String [] args) {
		new TenLabelsFrame(); // TenLabelsFrame 객체 생성하여 실행
	}
}
