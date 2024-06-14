package chapter10.practice.pr10;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DicAppWithDeleteAndViewAll extends JFrame {
	private JTextField eng = new JTextField(10);
	private JTextField kor = new JTextField(10);
	private JButton saveBtn = new JButton("저장");
	private JButton searchBtn = new JButton("찾기");
	private JButton deleteBtn = new JButton("삭제");
	private JButton viewBtn = new JButton("모두보기");
	private JLabel countLabel = new JLabel("0");
	private JTextArea ta = new JTextArea(7, 25);
	
	private HashMap<String, String> dic = new HashMap<String, String>(); // 단어 저장용 해시맵
	
	public DicAppWithDeleteAndViewAll() {
		super("단어 사전 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료		

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		saveBtn.setBackground(Color.YELLOW);
		searchBtn.setBackground(Color.GREEN);
		deleteBtn.setBackground(Color.MAGENTA);
		viewBtn.setBackground(Color.CYAN);

		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(saveBtn);
		c.add(searchBtn);
		c.add(deleteBtn);
		c.add(viewBtn);		
		c.add(countLabel);
		
		saveBtn.addActionListener(new ActionListener() { // 저장 버튼을 눌었을 때 처리
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String eText = eng.getText();
				String kText = kor.getText();
				if(eText.length() == 0 || kText.length() == 0) {
					ta.append("단어 미 입력 (" + eText + "," + kText + ")\n");
					return; // 영어나 한글의 단어 둘 중 하나가 입력되어 있지 않음
				}
				
				// 이미 존재하는 단어인지 판별
				if(dic.get(eText) == null)  { // 없는 단어
					ta.append("삽입 (" + eText + "," + kText + ")\n");
					int count = Integer.parseInt(countLabel.getText());
					count++;
					countLabel.setText(Integer.toString(count)); // 단어수 증가						
				}
				else // 있는 단어
					ta.append("변경 (" + eText + "," + kText + ")\n");					
				
				// 단어 추가 혹은 변경
				dic.put(eText, kText);
			}
		});
		
		searchBtn.addActionListener(new ActionListener() { // 검색 버튼을 눌렀을 때 처리
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String kText = dic.get(eng.getText());
				if(kText == null) 
					kText = "단어 없음";
				kor.setText(kText);
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() { // 삭제 버튼을 눌었을 때 처리
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String eText = eng.getText();
				if(eText.length() == 0) {
					ta.append("단어 미 입력 (" + eText + ")\n");
					return; // 영어 단어가 입력되어 있지 않음
				}

				String res = dic.remove(eText); // 단어 삭제
				
				// 이미 존재하는 단어인지 판별
				if(res == null)  { // 단어가 없어서 삭제할 수 없음
					ta.append("삭제 미처리 (" + eText + ")\n");
				}
				else { // 있는 단어
					int count = Integer.parseInt(countLabel.getText());
					count--;
					countLabel.setText(Integer.toString(count)); // 단어수 감소					
					ta.append("삭제 (" + eText + "," + res + ")\n");					
				}					
			}
		});

		viewBtn.addActionListener(new ActionListener() { // 모두 보기 버튼을 눌렀을 때 처리
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText(""); // 텍스트영역을 모두 지움
				 
				// 해시맵에 들어 있는 모든 (key, value) 쌍 출력
				Set<String> keys = dic.keySet(); // 키를 모두 Set 컬렉션에 받아옴
				Iterator<String> it = keys.iterator(); // Set에 저장된 키 문자열을 접근할 수 있는 Iterator 리턴
				while(it.hasNext()) {
					String eText = it.next(); // 키
					String kText = dic.get(eText); // 값
					ta.append("단어 (" + eText + "," + kText + ")\n");	
				}
			}
		});
		
		c.add(new JScrollPane(ta)); // 텍스트 영역을 스크롤 가능하도록 설정하여 패널에 추가
		setSize(300, 250); // 프레임 크기 설정
		setVisible(true); // 프레임을 화면에 표시
	}
	
	public static void main(String[] args) {
		new DicAppWithDeleteAndViewAll(); // DicAppWithDeleteAndViewAll 객체 생성하여 실행
	}

}
