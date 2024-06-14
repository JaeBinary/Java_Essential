package chapter10.practice.pr06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DigitChangerFrame extends JFrame {
	private JTextField src = new JTextField(8); // 입력용 텍스트필드
	private JTextField dest = new JTextField(8); // 출력용 텍스트필드
	private JRadioButton radio [] = new JRadioButton [4]; // 라디오버튼 배열 생성
	private String [] text = {"decimal", "binary", "octal", "hex"}; // 라디오버튼 텍스트 배열
	
	public DigitChangerFrame() {
		super("Digit Changer"); // 프레임 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 프로그램 종료 설정
		Container c = getContentPane(); // 컨텐트 팬 가져오기
		c.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
		
		ButtonGroup g = new ButtonGroup(); // 라디오버튼 그룹 생성
		MyItemListener listener = new MyItemListener(); // Item 리스너 생성
		
		// 컴포넌트 부착
		c.add(src); // 입력용 텍스트필드 추가
		c.add(new JLabel("->")); // 화살표 레이블 추가
		c.add(dest); // 출력용 텍스트필드 추가
		
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]); // 라디오버튼 생성
			radio[i].addItemListener(listener); // 리스너 부착
			c.add(radio[i]); // 라디오버튼을 컨텐트팬에 추가
			g.add(radio[i]); // 라디오버튼을 버튼그룹에 추가
		}
		
		setSize(280, 150); // 프레임 크기 설정
		setVisible(true); // 프레임을 화면에 표시
	}
	
	// 라디오버튼의 Item 리스너 클래스 정의
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() != ItemEvent.SELECTED)
				return;

			int n;
			String text = ((JRadioButton)e.getItem()).getText(); // 선택된 라디오버튼의 텍스트 가져오기
			try {
				switch(text) {		
					case "decimal": // 10진수 선택 시
						n = Integer.parseInt(src.getText()); // 입력된 텍스트를 정수로 변환
						dest.setText(Integer.toString(n)); // 10진수 문자열로 변환하여 출력용 텍스트필드에 설정
						break;
					case "binary" : // 2진수 선택 시
						n = Integer.parseInt(src.getText()); // 입력된 텍스트를 정수로 변환
						dest.setText(Integer.toBinaryString(n)); // 2진수 문자열로 변환하여 출력용 텍스트필드에 설정
						break;				
					case "octal" : // 8진수 선택 시
						n = Integer.parseInt(src.getText()); // 입력된 텍스트를 정수로 변환
						dest.setText(Integer.toOctalString(n)); // 8진수 문자열로 변환하여 출력용 텍스트필드에 설정
						break;						
					case "hex" : // 16진수 선택 시
						n = Integer.parseInt(src.getText()); // 입력된 텍스트를 정수로 변환
						dest.setText(Integer.toHexString(n)); // 16진수 문자열로 변환하여 출력용 텍스트필드에 설정
						break;				
				}
			} catch(NumberFormatException exp) {
				dest.setText("변환할 수 없습니다."); // 숫자로 변환할 수 없는 경우 메시지 출력
			}
		}
	}
	
	public static void main(String[] args) {
		new DigitChangerFrame(); // DigitChangerFrame 객체 생성하여 실행
	}

}
