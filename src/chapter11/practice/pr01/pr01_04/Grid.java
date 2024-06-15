package chapter11.practice.pr01.pr01_04; 			// chapter11.practice.pr01.pr01_04 패키지에 속하는 클래스임을 명시
import java.awt.Color; 								// java.awt 패키지의 Color 클래스를 임포트
import java.awt.Graphics; 							// java.awt 패키지의 Graphics 클래스를 임포트
import javax.swing.JFrame; 							// javax.swing 패키지의 JFrame 클래스를 임포트
import javax.swing.JPanel; 							// javax.swing 패키지의 JPanel 클래스를 임포트

// Grid 클래스는 JFrame을 상속받는다.
public class Grid extends JFrame {

    // Grid 생성자
    public Grid() {
        super("컨텐트팬을 10x10으로 나누는 격자 그리기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(150, 160); // 프레임의 크기를 가로 150, 세로 160으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            
            int dw = getWidth() / 10; // 패널의 너비를 10으로 나누어 각 격자의 너비 계산
            int dh = getHeight() / 10; // 패널의 높이를 10으로 나누어 각 격자의 높이 계산
            
            // 수직선 그리기
            for(int i = 1; i <= 9; i++) {
                g.drawLine(i * dw, 0, i * dw, getHeight()); // (i * dw, 0)에서 (i * dw, getHeight())까지 수직선 그리기
            }

            // 수평선 그리기
            for(int i = 1; i <= 9; i++) {
                g.drawLine(0, i * dh, getWidth(), i * dh); // (0, i * dh)에서 (getWidth(), i * dh)까지 수평선 그리기
            }
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        new Grid(); // Grid 객체를 생성하여 프로그램을 실행
    }
}
