package chapter09.practice.pr07; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// ButtonActionFrame 클래스는 JFrame을 상속받음
public class ButtonActionFrame extends JFrame {
    private String[] text = {"+2", "-1", "%4"}; // 버튼에 사용할 문자열 배열
    private JLabel la = new JLabel(); // 정수를 표시할 레이블
    private JButton[] btn = new JButton[text.length]; // 버튼 배열

    // 생성자 선언
    public ButtonActionFrame() {
        super("0으로 만들기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정
        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴

        // 정수 레이블 생성
        int num = (int)(Math.random() * 60 + 1); // 1에서 60 사이의 임의의 정수  
        la.setText(Integer.toString(num)); // 정수를 문자열로 만들어 레이블에 출력
        la.setFont(new Font("Gothic", Font.ITALIC, 20)); // 레이블의 폰트 설정
        JPanel p = new JPanel(); // 레이블을 담을 패널 생성
        c.add(p, BorderLayout.CENTER); // 패널을 중앙에 추가
        p.add(la); // 패널에 레이블 추가

        JPanel q = new JPanel(); // 버튼을 담을 패널 생성
        c.add(q, BorderLayout.SOUTH); // 패널을 아래쪽에 추가

        // 3개의 버튼 생성
        MyActionListener listener = new MyActionListener(); // Action 리스너 객체 생성
        for(int i = 0; i < text.length; i++) {
            btn[i] = new JButton(text[i]); // 버튼 생성
            btn[i].addActionListener(listener); // 리스너 달기
            q.add(btn[i]); // 패널에 버튼 추가
        }

        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // 내부 클래스 MyActionListener는 ActionListener를 구현
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ButtonActionFrame.this.setTitle("0으로 만들기"); // 타이틀 바 초기화

            int n = Integer.parseInt(la.getText()); // 현재 정수를 가져옴
            switch(e.getActionCommand()) { // 버튼의 명령어에 따라 다르게 동작
                case "+2":
                    n += 2; // 2 증가
                    btn[0].setEnabled(false); // 버튼 비활성화시켜 다시 클릭되지 않게 함
                    break;
                case "-1":
                    n--; // 1 감소
                    btn[1].setEnabled(false); // 버튼 비활성화시켜 다시 클릭되지 않게 함
                    break;
                case "%4":
                    n %= 4; // 4로 나눈 나머지 계산
                    btn[2].setEnabled(false); // 버튼 비활성화시켜 다시 클릭되지 않게 함                
                    break;
            }
            la.setText(Integer.toString(n)); // 정수를 문자열로 만들어 레이블에 출력

            if(n == 0) { // 정수가 0이 된 경우
                ButtonActionFrame.this.setTitle("성공"); // 타이틀을 "성공"으로 변경
                for(int i = 0; i < text.length; i++) {
                    btn[i].setEnabled(true); // 모든 버튼을 다시 활성화
                }
                int num = (int)(Math.random() * 60 + 1); // 1에서 60 사이의 임의의 정수  
                la.setText(Integer.toString(num)); // 새로운 정수를 레이블에 출력
            } else { // 정수가 0이 아닌 경우
                if(!btn[0].isEnabled() && !btn[1].isEnabled() && !btn[2].isEnabled()) {
                    setTitle("실패"); // 모든 버튼이 비활성화된 경우 타이틀을 "실패"로 변경
                }
            }            
        }
    }

    // main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        new ButtonActionFrame(); // ButtonActionFrame 인스턴스를 생성하여 프레임을 표시
    }
}
