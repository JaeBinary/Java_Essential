package chapter08.practice.pr04; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 TenColorButtonFrame 클래스 정의
public class TenColorButtonFrame extends JFrame {
    
    // 생성자 정의
    public TenColorButtonFrame() {
        super("Ten Color Buttons Frame"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container contentPane = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        contentPane.setLayout(new GridLayout(1, 10)); // 그리드 레이아웃으로 레이아웃 설정
        
        // 버튼에 사용할 색 배열
        Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
                Color.PINK, Color.LIGHT_GRAY}; 

        // 10개의 버튼 생성하여 패널에 추가
        for(int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i)); // 버튼에 숫자 표시
            button.setOpaque(true); // 배경색이 보이도록 설정
            button.setBackground(color[i]); // 각 버튼의 배경색 설정
            contentPane.add(button); // 컨텐트팬에 버튼 추가
        }
        
        setSize(500, 200); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new TenColorButtonFrame(); // TenColorButtonFrame 객체 생성하여 실행
    }
}
