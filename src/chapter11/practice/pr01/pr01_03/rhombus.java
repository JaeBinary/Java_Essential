package chapter11.practice.pr01.pr01_03; 			// chapter11.practice.pr01.pr01_03 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// rhombus 클래스는 JFrame을 상속받는다.
public class rhombus extends JFrame {

    // rhombus 생성자
    public rhombus() {
        super("컨텐트팬에 꽉차는 마름모"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(150, 160); // 프레임의 크기를 가로 150, 세로 160으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private int[] x = new int[4]; // x 좌표 배열
        private int[] y = new int[4]; // y 좌표 배열

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            g.setColor(Color.BLUE); // 파란색 선택
            
            // 마름모의 네 점의 좌표를 설정
            x[0] = getWidth() / 2; y[0] = 0; // 상단 중앙
            x[1] = 0; y[1] = getHeight() / 2; // 좌측 중앙
            x[2] = getWidth() / 2; y[2] = getHeight(); // 하단 중앙
            x[3] = getWidth(); y[3] = getHeight() / 2; // 우측 중앙

            g.drawPolygon(x, y, 4); // 마름모를 그린다
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        new rhombus(); // rhombus 객체를 생성하여 프로그램을 실행
    }
}
