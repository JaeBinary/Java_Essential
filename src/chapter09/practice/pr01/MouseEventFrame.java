package chapter09.practice.pr01; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// MouseEventFrame 클래스는 JFrame을 상속받음
public class MouseEventFrame extends JFrame {
    
    // 생성자 선언
    public MouseEventFrame() {
        super("마우스 올리기 내리기 연습"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setLayout(new FlowLayout()); // 레이아웃 매니저를 FlowLayout으로 설정

        JLabel label = new JLabel("자기야"); // "자기야" 텍스트를 가진 JLabel 생성
        // 마우스 이벤트 리스너 추가
        label.addMouseListener(new MouseAdapter() {
            // 마우스가 라벨 위에 올라갔을 때 호출되는 메소드
            public void mouseEntered(MouseEvent e) {
                JLabel la = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                la.setText("사랑해"); // 텍스트를 "사랑해"로 변경
            }
            // 마우스가 라벨을 벗어났을 때 호출되는 메소드
            public void mouseExited(MouseEvent e) {
                JLabel la = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                la.setText("자기야"); // 텍스트를 "자기야"로 변경
            }            
        });
        c.add(label); // 컨텐트팬에 라벨 추가
        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // main 메소드: 프로그램의 시작점
    static public void main(String[] args) {
        new MouseEventFrame(); // MouseEventFrame 인스턴스를 생성하여 프레임을 표시
    }
}
