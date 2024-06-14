package chapter09.practice.pr06; 		// 패키지 선언
import java.awt.*; 						// AWT(Abstract Window Toolkit) 패키지 import
import java.awt.event.*; 				// AWT 이벤트 패키지 import
import javax.swing.*; 					// 스윙 패키지 import

// Plate4x4FrameWithMouseListener 클래스는 JFrame을 상속받음
public class Plate4x4FrameWithMouseListener extends JFrame {

    // 생성자 선언
    public Plate4x4FrameWithMouseListener() {
        super("3x4 Color Frame"); // 프레임의 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬(ContentPane)을 가져옴
        c.setLayout(new GridLayout(4, 3)); // 4x3 그리드 레이아웃으로 설정

        JLabel[] label = new JLabel[12]; // 12개의 JLabel 배열 선언
        for(int i = 0; i < label.length; i++) {
            label[i] = new JLabel(Integer.toString(i)); // 라벨에 i를 문자열로 설정
            label[i].setOpaque(true); // 배경색이 보이도록 설정
            label[i].setBackground(Color.WHITE); // 초기 배경색을 흰색으로 설정
            c.add(label[i]); // 컨텐트팬에 라벨 추가

            // 마우스 이벤트 리스너 추가
            label[i].addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    JLabel label = (JLabel)e.getSource(); // 이벤트의 소스를 JLabel로 캐스팅
                    int r = (int)(Math.random() * 256); // 0~255 사이의 무작위 red 성분
                    int g = (int)(Math.random() * 256); // 0~255 사이의 무작위 green 성분
                    int b = (int)(Math.random() * 256); // 0~255 사이의 무작위 blue 성분
                    label.setBackground(new Color(r, g, b)); // 무작위 색으로 배경색 설정
                }

            });
        }
        setSize(270, 200); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        new Plate4x4FrameWithMouseListener(); // Plate4x4FrameWithMouseListener 인스턴스를 생성하여 프레임을 표시
    }
}
