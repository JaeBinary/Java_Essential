package chapter08.practice.pr01; 		// 패키지 선언
import javax.swing.*; 					// 스윙 패키지 임포트

// JFrame을 상속받는 MyFrame 클래스 정의
public class MyFrame extends JFrame {
    
    // 생성자 정의
    public MyFrame(String title) {
        super(title); // JFrame의 생성자 호출하여 프레임 제목 설정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        setSize(400, 200); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // main 메서드
    public static void main(String[] args) {
        new MyFrame("Let's study Java"); // MyFrame 객체 생성
    }
}
