package chapter11.practice.pr02; 			        // chapter11.practice.pr02 패키지에 속하는 클래스임을 명시
import java.awt.*; 							        // java.awt 패키지의 모든 클래스를 임포트
import javax.swing.*; 						        // javax.swing 패키지의 모든 클래스를 임포트

// ImageDrawPracticeFrame 클래스는 JFrame을 상속받는다.
public class ImageDrawPracticeFrame extends JFrame {

    // ImageDrawPracticeFrame 생성자
    public ImageDrawPracticeFrame() {
        super("이미지 그리기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(300, 300); // 프레임의 크기를 가로 300, 세로 300으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("images/practice/11-02/back.jpg"); // 이미지 로딩
        private Image img = icon.getImage(); // 이미지 객체 생성

        // MyPanel 생성자
        public MyPanel() {
            setLayout(new FlowLayout()); // 패널의 레이아웃을 FlowLayout으로 설정
            add(new JButton("Hello")); // 패널에 "Hello" 버튼 추가
        }

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            
            // 이미지를 패널 크기로 조절하여 그린다
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    // main 메서드: 프로그램의 시작점
    static public void main(String[] args) {
        new ImageDrawPracticeFrame(); // ImageDrawPracticeFrame 객체를 생성하여 프로그램을 실행
    }
}
