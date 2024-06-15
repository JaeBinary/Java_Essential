package chapter12.practice.pr01;
import java.awt.*;
import javax.swing.*;

public class RandomCircleFrame extends JFrame {
    public RandomCircleFrame() {
        super("원을 0.5초 간격으로 랜덤한 위치로 이동시키는 스레드");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new CirclePanel());
        setSize(250,250);
        setVisible(true);
    }
    
    // 원을 그리고 이동시키는 JPanel 내부 클래스
    class CirclePanel extends JPanel implements Runnable {
        private int x = 100; // 원이 그려지는 x 위치 초기값
        private int y = 100; // 원이 그려지는 y 위치 초기값
        
        public CirclePanel() {
            // 스레드 시작
            new Thread(this).start();
        }
        
        // JPanel의 paintComponent 메서드를 재정의하여 원을 그림
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.MAGENTA);
            g.drawOval(x, y, 50, 50); // (x, y)에서 50x50 크기 원 그리기
        }
        
        // 스레드의 run 메서드 구현
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(500); // 0.5초마다 한 번씩 실행
                } catch (InterruptedException e) {
                    return; // 스레드가 인터럽트되면 종료
                }
                
                // 원의 위치를 랜덤하게 변경
                x = (int)(Math.random() * this.getWidth()); // 패널의 너비 범위 내에서 랜덤 x 위치 선택
                y = (int)(Math.random() * this.getHeight()); // 패널의 높이 범위 내에서 랜덤 y 위치 선택
                
                repaint(); // 화면을 다시 그리도록 repaint 호출
            }
        }
    }
    
    // 메인 메서드에서 프레임 생성
    public static void main(String[] args) {
        new RandomCircleFrame();
    }
}
