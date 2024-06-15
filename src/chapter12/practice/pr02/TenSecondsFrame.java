package chapter12.practice.pr02;
import java.awt.Color;
import javax.swing.*;

public class TenSecondsFrame extends JFrame {
    public TenSecondsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 버튼 설정
        setSize(250,150); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
        
        TenSecondsThread th = new TenSecondsThread(); // TenSecondsThread 객체 생성
        th.start(); // 스레드 시작
    }
    
    // 특정 시간 동안 색상을 변경하는 스레드 클래스
    class TenSecondsThread extends Thread {
        @Override
        public void run() {
            setTitle("실행 시작"); // 프레임 제목 설정
            getContentPane().setBackground(Color.YELLOW); // 프레임의 배경색을 노란색으로 설정
            
            try {
                sleep(10000); // 10초(10000밀리초) 동안 스레드를 일시 정지
            } catch (InterruptedException e) {
                return; // 인터럽트 예외 발생 시 스레드 종료
            }
            
            setTitle("실행 종료"); // 프레임 제목 변경
            getContentPane().setBackground(Color.BLUE); // 프레임의 배경색을 파란색으로 변경
        }
    }

    // 메인 메서드에서 프레임 생성
    public static void main(String[] args) {
        new TenSecondsFrame();
    }
}
