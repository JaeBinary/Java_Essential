package chapter12.practice.pr06;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BubbleGameFrame extends JFrame {
    public BubbleGameFrame() {
        setTitle("버블 게임"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 동작 설정

        GamePanel p = new GamePanel(); // 게임 패널 생성
        setContentPane(p); // 프레임의 콘텐츠 팬으로 설정
        setSize(300,300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    public static void main(String[] args) {
        new BubbleGameFrame(); // BubbleGameFrame 객체 생성
    }
}

class GamePanel extends JPanel {
    public GamePanel() {
        setLayout(null); // 레이아웃을 null로 설정하여 절대 위치에 컴포넌트를 배치

        // 마우스 이벤트 리스너 추가
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                new BubbleThread(e.getX(), e.getY()).start(); // 버블 스레드 시작
            }
        });
    }

    // 버블을 움직이는 스레드 클래스
    class BubbleThread extends Thread {
        private JLabel bubble; // 버블 레이블

        // 생성자
        public BubbleThread(int bubbleX, int bubbleY) {
            ImageIcon img = new ImageIcon("images/practice/12-06/bubble.jpg"); // 이미지 아이콘 생성
            bubble = new JLabel(img); // 버블 레이블 생성
            bubble.setSize(img.getIconWidth(), img.getIconWidth()); // 버블 레이블 크기 설정
            bubble.setLocation(bubbleX, bubbleY); // 초기 위치 설정
            add(bubble); // 버블을 게임 패널에 추가
            repaint(); // 패널 다시 그리기 요청
        }

        // 스레드 실행 메서드
        public void run() {
            while(true) { // 무한 루프
                int x = bubble.getX(); // 버블의 x 좌표
                int y = bubble.getY() - 5; // 버블의 y 좌표 감소
                if(y < 0) { // 화면을 벗어나면
                    remove(bubble); // 버블 제거
                    repaint(); // 패널 다시 그리기 요청
                    return; // 스레드 종료
                }
                bubble.setLocation(x, y); // 새로운 위치로 버블 이동
                repaint(); // 패널 다시 그리기 요청
                try {
                    sleep(200); // 200밀리초 동안 스레드 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
