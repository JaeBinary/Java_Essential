package chapter09.practice.pr03; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// MouseDraggingFrame 클래스는 JFrame을 상속받음
public class MouseDraggingFrame extends JFrame {

    // 생성자 선언
    public MouseDraggingFrame() {
        super("드래깅 중 YELLOW로 변경"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setBackground(Color.GREEN); // 컨텐트팬의 배경색을 초록색으로 설정

        MyMouseListener ml = new MyMouseListener(); // 마우스 리스너 인스턴스 생성
        c.addMouseMotionListener(ml); // 마우스 모션 리스너 등록
        c.addMouseListener(ml); // 마우스 리스너 등록

        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyMouseListener 클래스는 MouseAdapter를 상속받고 MouseMotionListener 인터페이스 구현
    class MyMouseListener extends MouseAdapter implements MouseMotionListener {
        // 마우스 드래그 중에 호출되는 메소드
        public void mouseDragged(MouseEvent e) {
            Container c = (Container)e.getSource(); // 이벤트의 소스를 Container로 캐스팅
            c.setBackground(Color.YELLOW); // 배경색을 노란색으로 변경
        }

        // 마우스 이동 중에 호출되는 메소드 (사용되지 않음)
        public void mouseMoved(MouseEvent e) {}

        // 마우스 버튼이 떼어졌을 때 호출되는 메소드
        public void mouseReleased(MouseEvent e) {
            Container c = (Container)e.getSource(); // 이벤트의 소스를 Container로 캐스팅
            c.setBackground(Color.GREEN); // 배경색을 초록색으로 변경
        }        
    }

    // main 메소드: 프로그램의 시작점
    static public void main(String[] args) {
        new MouseDraggingFrame(); // MouseDraggingFrame 인스턴스를 생성하여 프레임을 표시
    }
}
