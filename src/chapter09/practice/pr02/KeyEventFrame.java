package chapter09.practice.pr02; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// KeyEventFrame 클래스는 JFrame을 상속받음
public class KeyEventFrame extends JFrame {

    // 생성자 선언
    public KeyEventFrame() {
        super("키 누르기 떼기 연습"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setBackground(Color.CYAN); // 컨텐트팬의 배경색을 시안(Cyan)으로 설정

        // 키 이벤트 리스너 추가
        c.addKeyListener(new KeyAdapter() {
            // 키가 눌렸을 때 호출되는 메소드
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == 'R') { // 눌린 키가 'R'일 경우
                    getContentPane().setBackground(Color.RED); // 배경색을 빨간색으로 변경
                }
            }
            // 키가 떼졌을 때 호출되는 메소드
            public void keyReleased(KeyEvent e) {
                if(e.getKeyChar() == 'R') { // 떼진 키가 'R'일 경우
                    getContentPane().setBackground(Color.CYAN); // 배경색을 시안으로 변경
                }
            }            
        });

        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정

        c.setFocusable(true); // 컨텐트팬이 포커스를 받을 수 있도록 설정
        c.requestFocus(); // 컨텐트팬에 포커스를 요청
    }

    // main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        new KeyEventFrame(); // KeyEventFrame 인스턴스를 생성하여 프레임을 표시
    }
}
