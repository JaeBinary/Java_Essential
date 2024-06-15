package chapter11.practice.pr06; 					// chapter11.practice.pr05 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import java.awt.event.*; 							// java.awt 이벤트 관련 패키지를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// PlusMinusImageFrame 클래스는 JFrame을 상속받는다.
public class PlusMinusImageFrame extends JFrame {
    
    // PlusMinusImageFrame 생성자
    public PlusMinusImageFrame(){
        super("그래픽 이미지 10% 확대 축소"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(300, 300); // 프레임의 크기를 가로 300, 세로 300으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
        
        getContentPane().setFocusable(true); // 컴포넌트가 포커스를 받을 수 있도록 설정
        getContentPane().requestFocus(); // 컴포넌트에 포커스 지정
    }
    
    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private ImageIcon icon = new ImageIcon("images/practice/11-06/apple.jpg"); // 이미지 로드
        private Image img = icon.getImage(); // 이미지 객체
        private double width; // 이미지의 가로 크기
        private double height; // 이미지의 세로 크기
        
        // MyPanel 생성자
        public MyPanel() {
            width = img.getWidth(this); // 이미지의 초기 가로 크기 설정
            height = img.getHeight(this); // 이미지의 초기 세로 크기 설정
            
            // 키 이벤트 리스너 추가
            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() == '+') { // '+' 키가 눌렸을 때
                        width = width * 1.1; // 가로 크기 10% 확대
                        height = height * 1.1; // 세로 크기 10% 확대
                        repaint(); // 패널 다시 그리기 요청
                    } else if (e.getKeyChar() == '-') { // '-' 키가 눌렸을 때
                        if (width * 0.9 < 1 || height * 0.9 < 1) 
                            return; // 크기가 1보다 작아지는 것을 방지
                        width = width * 0.9; // 가로 크기 10% 축소
                        height = height * 0.9; // 세로 크기 10% 축소
                        repaint(); // 패널 다시 그리기 요청
                    }
                }
            });
        }
        
        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            g.drawImage(img, 10, 10, (int)width, (int)height, this); // 이미지 그리기
        }        
    }

    // main 메서드: 프로그램의 시작점
    static public void main(String[] args) {
        new PlusMinusImageFrame(); // PlusMinusImageFrame 객체를 생성하여 프로그램을 실행
    }
}
