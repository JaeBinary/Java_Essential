package chapter08.practice.pr02; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 MyBorderLayoutFrame 클래스 정의
public class MyBorderLayoutFrame extends JFrame {
    
    // 생성자 정의
    public MyBorderLayoutFrame() {
        super("BorderLayout Practice"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container c = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        c.setLayout(new BorderLayout(50, 5)); // BorderLayout으로 레이아웃 설정, 수평 간격 50, 수직 간격 5
        
        // 버튼을 생성하여 컨테이너에 추가
        c.add(new JButton("East"), BorderLayout.EAST);
        c.add(new JButton("West"), BorderLayout.WEST);
        c.add(new JButton("North"), BorderLayout.NORTH);
        c.add(new JButton("South"), BorderLayout.SOUTH);
        c.add(new JButton("Center"), BorderLayout.CENTER);
        
        setSize(400, 200); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new MyBorderLayoutFrame(); // MyBorderLayoutFrame 객체 생성하여 실행
    }
}
