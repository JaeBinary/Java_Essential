package chapter11.practice.pr04; 					// chapter11.practice.pr04 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import java.awt.event.*; 							// java.awt 이벤트 관련 패키지를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// GraphicsAndMouseDraggingFrame 클래스는 JFrame을 상속받는다.
public class GraphicsAndMouseDraggingFrame extends JFrame {
    
    // GraphicsAndMouseDraggingFrame 생성자
    public GraphicsAndMouseDraggingFrame() {
        super("이미지 위에 원 드래깅 연습"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(300, 300); // 프레임의 크기를 가로 300, 세로 300으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("images/practice/11-04/back.jpg"); // 이미지 로딩
        private Image img = icon.getImage(); // 이미지 객체
        private int ovalX = 100, ovalY = 100; // 원의 초기 위치 설정

        // MyPanel 생성자
        public MyPanel() {
            // 마우스 드래그 이벤트 리스너 등록
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    ovalX = e.getX(); // 드래그한 위치의 X 좌표를 원의 X 좌표로 설정
                    ovalY = e.getY(); // 드래그한 위치의 Y 좌표를 원의 Y 좌표로 설정
                    repaint(); // 패널 다시 그리기 요청
                }
            });
        }

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); // 이미지를 패널 크기에 맞춰 그린다
            g.setColor(Color.GREEN); // 원의 색상을 녹색으로 설정
            g.fillOval(ovalX, ovalY, 20, 20); // (ovalX, ovalY) 위치에 20x20 크기의 원을 그린다
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        new GraphicsAndMouseDraggingFrame(); // GraphicsAndMouseDraggingFrame 객체를 생성하여 프로그램을 실행
    }
}
