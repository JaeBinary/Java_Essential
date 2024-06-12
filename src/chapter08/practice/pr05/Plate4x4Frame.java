package chapter08.practice.pr05; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 Plate4x4Frame 클래스 정의
public class Plate4x4Frame extends JFrame {
    
    // 생성자 정의
    public Plate4x4Frame() {
        super("4x4 Color Frame"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container c = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        c.setLayout(new GridLayout(4, 4)); // 그리드 레이아웃으로 레이아웃 설정
        
        JLabel[] label = new JLabel[16]; // 레이블 배열 생성
        Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
                Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
                Color.BLACK, Color.ORANGE, Color.BLUE, Color.MAGENTA}; // 색 배열 생성

        // 레이블을 생성하여 패널에 추가하고 각 레이블의 배경색 설정
        for(int i = 0; i < label.length; i++) {
            label[i] = new JLabel(Integer.toString(i)); // 레이블에 숫자 표시
            label[i].setOpaque(true); // 배경색이 보이도록 설정
            label[i].setBackground(color[i]); // 각 레이블의 배경색 설정
            c.add(label[i]); // 컨텐트팬에 레이블 추가
        }
        
        setSize(500, 200); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new Plate4x4Frame(); // Plate4x4Frame 객체 생성하여 실행
    }
}
