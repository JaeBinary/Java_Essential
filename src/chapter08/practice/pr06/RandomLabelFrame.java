package chapter08.practice.pr06; 		// 패키지 선언
import java.awt.*; 						// AWT 패키지 임포트
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 RandomLabelFrame 클래스 정의
public class RandomLabelFrame extends JFrame {
    
    // 생성자 정의
    public RandomLabelFrame() {
        super("Random Labels"); // JFrame의 생성자를 호출하여 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        Container c = getContentPane(); // 프레임의 컨텐트 팬을 가져옴
        c.setLayout(null); // 배치관리자를 null로 설정하여 절대 위치로 컴포넌트를 배치
        
        // 20개의 레이블을 생성하여 컨테이너에 추가
        for(int i = 0; i < 20; i++) {
            JLabel label = new JLabel(Integer.toString(i)); // 레이블에 숫자 표시
            label.setForeground(Color.MAGENTA); // 레이블의 전경색을 설정
            int x = (int)(Math.random() * 220) + 30; // x 좌표를 랜덤으로 설정
            int y = (int)(Math.random() * 220) + 30; // y 좌표를 랜덤으로 설정
            label.setLocation(x, y); // 레이블의 위치 설정
            label.setSize(20, 20); // 레이블의 크기 설정
            c.add(label); // 컨텐트팬에 레이블 추가
        }
        
        setSize(300, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new RandomLabelFrame(); // RandomLabelFrame 객체 생성하여 실행
    }
}
