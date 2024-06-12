package chapter08.practice.pr07_2; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import java.awt.event.ActionEvent; 		// ActionEvent 클래스 임포트
import java.awt.event.ActionListener; 	// ActionListener 인터페이스 임포트
import java.util.Vector; 				// Vector 클래스 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 MultiPanelFrameWithListener 클래스 정의
public class MultiPanelFrameWithListener extends JFrame {
    private SouthPanel southPanel = new SouthPanel(); // SouthPanel 객체 생성
    private CenterPanel centerPanel = new CenterPanel(); // CenterPanel 객체 생성
    private NorthPanel northPanel = new NorthPanel(); // NorthPanel 객체 생성
    
    // 생성자 정의
    public MultiPanelFrameWithListener() {
        super("3개의 패널을 가진 프레임"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container c = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        c.setLayout(new BorderLayout()); // BorderLayout으로 레이아웃 설정
        
        // SouthPanel, CenterPanel, NorthPanel을 프레임에 추가
        c.add(southPanel, BorderLayout.SOUTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(northPanel, BorderLayout.NORTH);
        
        setSize(300, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
        
        centerPanel.draw(10); // CenterPanel의 draw 메서드를 호출하여 별(*) 그리기
    }
    
    // SouthPanel 클래스 정의
    class SouthPanel extends JPanel {
        private JButton btn = new JButton("별 개수 수정"); // 별 개수 수정 버튼
        private JTextField tf = new JTextField(15); // 텍스트 필드
        
        // 생성자 정의
        public SouthPanel() {
            setBackground(Color.LIGHT_GRAY); // 배경색 설정
            setOpaque(true); // 투명도 설정
            setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout으로 레이아웃 설정
            add(btn); // 버튼 추가
            add(tf); // 텍스트 필드 추가
            
            // 별 개수 수정 버튼에 ActionListener 추가
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(tf.getText().length() == 0) // 텍스트 필드가 비어있으면 종료
                        return;
                    
                    int n = Integer.parseInt(tf.getText()); // 텍스트 필드의 값을 정수로 변환
                    centerPanel.draw(n); // CenterPanel의 draw 메서드 호출하여 별(*) 그리기
                }
            });
        }
    }
    
    // CenterPanel 클래스 정의
    class CenterPanel extends JPanel {
        private int count = 10; // 별 개수를 나타내는 변수
        private Vector<JLabel> list = new Vector<JLabel>(); // JLabel을 저장하는 Vector
        
        // 생성자 정의
        public CenterPanel() {
            setBackground(Color.WHITE); // 배경색 설정
            setLayout(null); // 배치관리자 없음
        }

        // 별(*)을 그리는 메서드
        public void draw() {
            for(int i = 0; i < list.size(); i++) {
                JLabel label = list.get(i);
                label.setSize(20, 20); // 크기 설정
                label.setForeground(Color.RED); // 전경색 설정
                label.setLocation((int)(Math.random() * (getWidth() - 20)), (int)(Math.random() * (getHeight() - 20))); // 위치 설정
            }
        }

        // 별(*)을 새로 그리는 메서드
        public void draw(int count) {
            list.removeAllElements(); // 리스트에 저장된 컴포넌트 모두 삭제
            this.removeAll(); // 컨테이너의 모든 컴포넌트 삭제
            this.count = count; // 별 개수 설정
            for(int i = 0; i < count; i++) {
                JLabel label = new JLabel("*"); // 별(*) 레이블 생성
                list.add(label); // 리스트에 추가
                label.setSize(20, 20); // 크기 설정
                label.setForeground(Color.RED); // 전경색 설정
                label.setLocation((int)(Math.random() * (getWidth() - 20)), (int)(Math.random() * (getHeight() - 20))); // 위치 설정
                add(label); // 패널에 레이블 추가
            }
            repaint(); // 다시 그리기
        }
    }
    
    // NorthPanel 클래스 정의
    class NorthPanel extends JPanel {
        private JButton newBtn = new JButton("새로 배치"); // 새로 배치 버튼
        private JButton exitBtn = new JButton("종료"); // 종료 버튼
        
        // 생성자 정의
        public NorthPanel() {
            setBackground(Color.YELLOW); // 배경색 설정
            setOpaque(true); // 투명도 설정
            setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
            add(newBtn); // 새로 배치 버튼 추가
            add(exitBtn); // 종료 버튼 추가
            
            // 새로 배치 버튼에 ActionListener 추가
            newBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    centerPanel.draw(); // CenterPanel의 draw 메서드 호출하여 별(*) 다시 배치
                }
            });
            
            // 종료 버튼에 ActionListener 추가
            exitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); // 시스템 종료
                }
            });
        }
    }
    
    // main 메소드 정의
    public static void main(String[] args) {
        new MultiPanelFrameWithListener(); // MultiPanelFrameWithListener 객체 생성
    }
}
