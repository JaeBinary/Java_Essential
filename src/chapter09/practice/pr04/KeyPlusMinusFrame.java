package chapter09.practice.pr04; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// KeyPlusMinusFrame 클래스는 JFrame을 상속받음
public class KeyPlusMinusFrame extends JFrame {

    // 생성자 선언
    public KeyPlusMinusFrame() {
        super("+,- 키로 폰트 크기 조절"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setLayout(new FlowLayout()); // 레이아웃 매니저를 FlowLayout으로 설정
        
        JLabel label = new JLabel("Love Java"); // "Love Java" 텍스트를 가진 JLabel 생성
        label.setFont(new Font("TimesRoman", Font.PLAIN, 10)); // 폰트를 TimesRoman, 크기 10으로 설정

        // 키 이벤트 리스너 추가
        label.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '+') { // '+' 키가 눌렸을 경우
                    JLabel la = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                    Font f = la.getFont(); // 현재 폰트를 가져옴
                    int size = f.getSize(); // 현재 폰트 크기를 가져옴
                    la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5)); // 폰트 크기를 5 증가시켜 설정
                } else if(e.getKeyChar() == '-') { // '-' 키가 눌렸을 경우
                    JLabel la = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                    Font f = la.getFont(); // 현재 폰트를 가져옴
                    int size = f.getSize(); // 현재 폰트 크기를 가져옴
                    if(size <= 5) // 폰트 크기가 5 이하인 경우 폰트 크기를 줄이지 않음
                        return;
                    la.setFont(new Font("TimesRoman", Font.PLAIN, size - 5)); // 폰트 크기를 5 감소시켜 설정
                }                
            }
        });

        c.add(label); // 컨텐트팬에 라벨 추가
        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정

        label.setFocusable(true); // 라벨이 포커스를 받을 수 있도록 설정
        label.requestFocus(); // 라벨에 포커스를 요청
    }

    // main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        new KeyPlusMinusFrame(); // KeyPlusMinusFrame 인스턴스를 생성하여 프레임을 표시
    }
}
