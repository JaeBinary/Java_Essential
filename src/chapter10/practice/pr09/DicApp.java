package chapter10.practice.pr09;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DicApp extends JFrame {
	private JTextField eng = new JTextField(10); // 영어 단어 입력 필드
	private JTextField kor = new JTextField(10); // 한글 뜻 입력 필드
	private JButton saveBtn = new JButton("저장"); // 저장 버튼
	private JButton searchBtn = new JButton("찾기"); // 찾기 버튼
	private JLabel countLabel = new JLabel("0"); // 단어 수를 표시하는 레이블
	private JTextArea ta = new JTextArea(7, 25); // 결과를 출력하는 텍스트 영역
	
	private HashMap<String, String> dic = new HashMap<String, String>(); // 단어 저장용 해시맵
	
	public DicApp() {
		super("단어 사전 만들기"); // 프레임 제목 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료 버튼(X)을 클릭하면 프로그램 종료		

		Container c = getContentPane(); // 컨텐트 팬 가져오기
		c.setLayout(new FlowLayout()); // FlowLayout으로 설정
		
		saveBtn.setBackground(Color.YELLOW); // 저장 버튼 배경색 설정
		searchBtn.setBackground(Color.GREEN); // 찾기 버튼 배경색 설정
		
		// 컴포넌트들을 패널에 추가
		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(saveBtn);
		c.add(searchBtn);		
		c.add(countLabel);
		
		// 저장 버튼에 ActionListener 추가
		saveBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String eText = eng.getText(); // 영어 단어 가져오기
				String kText = kor.getText(); // 한글 뜻 가져오기
				if(eText.length() == 0 || kText.length() == 0) {
					ta.append("단어 미 입력 (" + eText + "," + kText + ")\n");
					return; // 영어나 한글의 단어 둘 중 하나가 입력되어 있지 않음
				}
				
				// 이미 존재하는 단어인지 판별
				if(dic.get(eText) == null)  { // 새로운 단어
					ta.append("삽입 (" + eText + "," + kText + ")\n");
					int count = Integer.parseInt(countLabel.getText());
					count++;
					countLabel.setText(Integer.toString(count)); // 단어수 증가					
				} else { // 이미 있는 단어인 경우
					ta.append("변경 (" + eText + "," + kText + ")\n");					
				}
				
				// 단어 추가 혹은 변경
				dic.put(eText, kText);
			}
		});
		
		// 찾기 버튼에 ActionListener 추가
		searchBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				String kText = dic.get(eng.getText()); // 해시맵에서 영어 단어에 해당하는 한글 뜻 가져오기
				if(kText == null) 
					kText = "단어 없음";
				kor.setText(kText); // 한글 뜻을 한글 입력 필드에 설정
			}
		});
		
		c.add(new JScrollPane(ta)); // 텍스트 영역을 스크롤 가능하게 하여 패널에 추가
		setSize(300, 250); // 프레임 크기 설정
		setVisible(true); // 프레임을 화면에 표시
	}
	
	public static void main(String[] args) {
		new DicApp(); // DicApp 객체 생성하여 실행
	}
}
