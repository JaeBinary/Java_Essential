package chapter09.practice.prBonus01; 	// 패키지 선언
import java.awt.*; 						// AWT 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// MouseWheelFrame 클래스는 JFrame을 상속받음
public class MouseWheelFrame extends JFrame {

    // 생성자 선언
    public MouseWheelFrame() {
        super("마우스 휠 굴리기 연습"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setLayout(new FlowLayout()); // FlowLayout으로 설정

        JLabel label = new JLabel("Love Java"); // 텍스트를 가진 레이블 생성
        label.setFont(new Font("Arial", Font.PLAIN, 10)); // 폰트 설정 (Arial, 일반체, 크기 10)

        // 마우스 휠 이벤트 리스너 추가
        label.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                int n = e.getWheelRotation(); // 마우스 휠의 회전 방향을 가져옴
                if (n < 0) { // 위로 스크롤할 때 (폰트를 작게)
                    JLabel la = (JLabel) e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                    Font f = la.getFont(); // 현재 레이블의 폰트를 가져옴
                    int size = f.getSize(); // 현재 폰트의 크기를 가져옴
                    if (size <= 5)
                        return; // 폰트 크기가 5보다 작거나 같으면 더 이상 줄이지 않음
                    la.setFont(new Font("Arial", Font.PLAIN, size - 5)); // 폰트 크기를 5만큼 줄임
                } else { // 아래로 스크롤할 때 (폰트를 크게)
                    JLabel la = (JLabel) e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                    Font f = la.getFont(); // 현재 레이블의 폰트를 가져옴
                    int size = f.getSize(); // 현재 폰트의 크기를 가져옴
                    la.setFont(new Font("Arial", Font.PLAIN, size + 5)); // 폰트 크기를 5만큼 늘림
                }
            }
        });

        c.add(label); // 컨텐트팬에 레이블 추가
        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        new MouseWheelFrame(); // MouseWheelFrame 인스턴스를 생성하여 프레임을 표시
    }
}
