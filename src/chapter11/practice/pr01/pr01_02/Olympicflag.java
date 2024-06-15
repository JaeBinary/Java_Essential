package chapter11.practice.pr01.pr01_02; 			// chapter11.practice.pr01.pr01_02 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// Olympicflag 클래스는 JFrame을 상속받는다.
public class Olympicflag extends JFrame {

    // Olympicflag 생성자
    public Olympicflag() {
        super("오륜기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(210, 150); // 프레임의 크기를 가로 210, 세로 150으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            
            // 오륜기의 다섯 개의 원을 그린다.
            g.setColor(Color.BLUE); // 파란색 선택
            g.drawOval(10, 10, 50, 50); // (10, 10) 위치에 50x50 크기의 원을 그림
            
            g.setColor(Color.BLACK); // 검은색 선택
            g.drawOval(70, 10, 50, 50); // (70, 10) 위치에 50x50 크기의 원을 그림
            
            g.setColor(Color.RED); // 빨간색 선택
            g.drawOval(130, 10, 50, 50); // (130, 10) 위치에 50x50 크기의 원을 그림
            
            g.setColor(Color.YELLOW); // 노란색 선택
            g.drawOval(40, 30, 50, 50); // (40, 30) 위치에 50x50 크기의 원을 그림
            
            g.setColor(Color.GREEN); // 초록색 선택
            g.drawOval(100, 30, 50, 50); // (100, 30) 위치에 50x50 크기의 원을 그림
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        new Olympicflag(); // Olympicflag 객체를 생성하여 프로그램을 실행
    }
}
