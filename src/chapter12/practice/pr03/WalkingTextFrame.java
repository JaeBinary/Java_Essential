package chapter12.practice.pr03;
import java.awt.*;
import javax.swing.*;

public class WalkingTextFrame extends JFrame {
    public WalkingTextFrame() {
        super("걸어서 나타나는 텍스트를 가진 레이블"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 버튼 설정
        
        Container c = getContentPane(); // 콘텐츠 팬 가져오기
        c.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
        
        // WalkingLabel 객체를 생성하여 콘텐츠 팬에 추가
        c.add(new WalkingLabel("나는 당신을 사랑합니다."));
        
        setSize(250,150); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    // 걸어서 나타나는 텍스트를 구현한 JLabel을 생성하고 스레드를 이용해 텍스트를 동적으로 변경하는 내부 클래스
    class WalkingLabel extends JLabel implements Runnable {
        private String text; // 표시할 텍스트
        private int count = 1; // 화면에 보일 글자 개수 초기값
        
        public WalkingLabel(String text) {
            this.text = text; // 텍스트 초기화
            new Thread(this).start(); // 스레드 시작
        }
        
        @Override
        public void run() {
            while(true) { // 무한 루프
                try {
                    Thread.sleep(500); // 0.5초마다
                } catch (InterruptedException e) {
                    return; // 인터럽트 예외 발생 시 스레드 종료
                }

                // 텍스트의 0에서 count 개수만큼의 부분 문자열을 추출하여 설정
                String s = text.substring(0, count); 
                setText(s); // JLabel에 설정
                
                // count 값을 텍스트의 글자 수에 맞게 조정
                count = (count + 1) % (text.length() + 1);
                if (count == 0) {
                    count = 1; // count가 0이 되면 다시 1부터 시작
                }
            }
        }
    }
    
    // 메인 메서드에서 프레임 생성
    public static void main(String[] args) {
        new WalkingTextFrame();
    }
}
