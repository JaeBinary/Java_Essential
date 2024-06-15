package chapter11.practice.pr03.pr03_01; 			// chapter11.practice.pr03.pr03_01 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// TwoImageFrame 클래스는 JFrame을 상속받는다.
public class TwoImageFrame extends JFrame {
    
    // TwoImageFrame 생성자
    public TwoImageFrame() {
        setTitle("두 이미지 나란히 보이기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(300, 300); // 프레임의 크기를 가로 300, 세로 300으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private Image imgA = new ImageIcon("images/practice/11-03-01/a.jpg").getImage(); // 첫 번째 이미지 로딩
        private Image imgB = new ImageIcon("images/practice/11-03-01/b.jpg").getImage(); // 두 번째 이미지 로딩

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            
            // 첫 번째 이미지를 패널의 왼쪽 절반에 그린다.
            g.drawImage(imgA, 0, 0, getWidth()/2, getHeight(), this);
            
            // 두 번째 이미지를 패널의 오른쪽 절반에 그린다.
            g.drawImage(imgB, getWidth()/2, 0, getWidth()/2, getHeight(), this);
        }
    }

    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        new TwoImageFrame(); // TwoImageFrame 객체를 생성하여 프로그램을 실행
    }
}
