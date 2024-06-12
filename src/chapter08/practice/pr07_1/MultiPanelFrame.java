package chapter08.practice.pr07_1; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import java.util.Vector; 				// Vector 클래스 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 MultiPanelFrame 클래스 정의
public class MultiPanelFrame extends JFrame {
    private SouthPanel southPanel = new SouthPanel(); // SouthPanel 객체 생성
    private CenterPanel centerPanel = new CenterPanel(); // CenterPanel 객체 생성
    private NorthPanel northPanel = new NorthPanel(); // NorthPanel 객체 생성
    
    // 생성자 정의
    public MultiPanelFrame() {
        super("3개의 패널을 가진 프레임"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container c = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        c.setLayout(new BorderLayout()); // BorderLayout으로 레이아웃 설정
        
        // SouthPanel, CenterPanel, NorthPanel을 프레임에 추가
        c.add(southPanel, BorderLayout.SOUTH);
        c.add(centerPanel, BorderLayout.CENTER);
        c.add(northPanel, BorderLayout.NORTH);
        
        setSize(300, 250); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
        
        centerPanel.draw(); // CenterPanel의 draw 메서드 호출하여 별(*) 그리기
    }
    
    // SouthPanel 클래스 정의
    class SouthPanel extends JPanel {
        // 생성자 정의
        public SouthPanel() {
            setBackground(Color.LIGHT_GRAY); // 배경색 설정
            setOpaque(true); // 투명도 설정
            setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout으로 레이아웃 설정
            add(new JButton("별 개수 수정")); // 버튼 추가
            add(new JTextField(15)); // 텍스트 필드 추가
        }
    }
    
    // CenterPanel 클래스 정의
    class CenterPanel extends JPanel {
        private int count = 10; // 별 개수를 나타내는 변수
        
        // 생성자 정의
        public CenterPanel() {
            setBackground(Color.WHITE); // 배경색 설정
            setLayout(null); // 배치관리자 없음
        }
        
        // 별(*)을 그리는 메서드
        public void draw() {
            for(int i = 0; i < count; i++) {
                JLabel label = new JLabel("*"); // 별(*) 레이블 생성
                label.setSize(20, 20); // 크기 설정
                label.setForeground(Color.RED); // 전경색 설정
                int x = (int)(Math.random() * (getWidth() - 20)); // x 좌표 랜덤 설정
                int y = (int)(Math.random() * (getHeight() - 20)); // y 좌표 랜덤 설정
                label.setLocation(x, y); // 위치 설정
                add(label); // 패널에 레이블 추가
            }
        }
    }
    
    // NorthPanel 클래스 정의
    class NorthPanel extends JPanel {
        // 생성자 정의
        public NorthPanel() {
            setBackground(Color.YELLOW); // 배경색 설정
            setOpaque(true); // 투명도 설정
            setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
            add(new JButton("새로 배치")); // 버튼 추가
            add(new JButton("종료")); // 버튼 추가
        }
    }
    
    // main 메서드
    public static void main(String[] args) {
        new MultiPanelFrame(); // MultiPanelFrame 객체 생성하여 실행
    }
}
