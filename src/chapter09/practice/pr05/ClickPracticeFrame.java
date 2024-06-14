package chapter09.practice.pr05; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// ClickPracticeFrame 클래스는 JFrame을 상속받음
public class ClickPracticeFrame extends JFrame {

    // 생성자 선언
    public ClickPracticeFrame() {
        super("클릭 연습"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setLayout(null); // 레이아웃 매니저를 사용하지 않음(null)

        JLabel label = new JLabel("C"); // "C" 텍스트를 가진 JLabel 생성
        label.setLocation(50, 50); // 라벨의 초기 위치 설정
        label.setSize(20, 20); // 라벨의 크기 설정

        // 마우스 이벤트 리스너 추가
        label.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JLabel la = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                Container c = la.getParent(); // 라벨의 부모 컨테이너를 가져옴

                // 새로운 위치를 계산할 때 프레임 경계를 벗어나지 않도록 함
                int xBound = c.getWidth() - la.getWidth(); // 레이블의 폭 만큼 감소
                int yBound = c.getHeight() - la.getHeight(); // 레이블의 높이 만큼 감소                
                int x = (int)(Math.random() * xBound); // 0부터 xBound 사이의 무작위 x 좌표
                int y = (int)(Math.random() * yBound); // 0부터 yBound 사이의 무작위 y 좌표
                
                la.setLocation(x, y); // 라벨의 새로운 위치 설정
            }
        });

        c.add(label); // 컨텐트팬에 라벨 추가

        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // main 메소드: 프로그램의 시작점
    static public void main(String[] args) {
        new ClickPracticeFrame(); // ClickPracticeFrame 인스턴스를 생성하여 프레임을 표시
    }
}
