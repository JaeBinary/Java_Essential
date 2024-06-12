package chapter08.practice.pr03; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 FlowLayoutPractice 클래스 정의
public class FlowLayoutPractice extends JFrame {
    
    // 생성자 정의
    public FlowLayoutPractice() {
        super("FlowLayout Practice"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container contentPane = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        
        contentPane.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
        
        // 레이블과 버튼을 생성하여 컨테이너에 추가
        contentPane.add(new JLabel("100"));
        contentPane.add(new JLabel("+"));
        contentPane.add(new JLabel("200"));
        contentPane.add(new JButton("="));
        contentPane.add(new JLabel("300"));

        setSize(400, 100); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new FlowLayoutPractice(); // FlowLayoutPractice 객체 생성하여 실행
    }
}
