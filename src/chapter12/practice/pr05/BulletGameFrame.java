package chapter12.practice.pr05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BulletGameFrame extends JFrame {
    public BulletGameFrame() {
        setTitle("사격 게임"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 버튼 설정

        GamePanel p = new GamePanel(); // 게임 패널 생성
        setContentPane(p); // 프레임의 콘텐츠 팬으로 설정
        setSize(300,300); // 프레임 크기 설정
        setResizable(false); // 프레임 크기 조절 금지
        setVisible(true); // 프레임을 화면에 표시

        p.startGame(); // 게임 시작 메서드 호출
    }

    public static void main(String [] args) {
        new BulletGameFrame(); // BulletGameFrame 객체 생성
    }
}

class GamePanel extends JPanel {
    private TargetThread targetThread = null; // 타겟을 움직이는 스레드
    private JLabel baseLabel = new JLabel(); // 플레이어 베이스 레이블
    private JLabel bulletLabel = new JLabel(); // 총알 레이블
    private JLabel targetLabel; // 타겟 레이블

    public GamePanel() {
        setLayout(null); // 레이아웃을 null로 설정하여 절대 위치에 컴포넌트를 배치

        baseLabel.setSize(40,40); // 베이스 레이블 크기 설정
        baseLabel.setOpaque(true); // 배경색을 표시하기 위해 true로 설정
        baseLabel.setBackground(Color.BLACK); // 검은색 배경 설정

        ImageIcon img = new ImageIcon("images/practice/12-05/chicken.jpg"); // 이미지 아이콘 생성
        targetLabel = new JLabel(img); // 타겟 레이블에 이미지 아이콘 설정
        targetLabel.setSize(img.getIconWidth(), img.getIconWidth()); // 타겟 레이블 크기 설정

        bulletLabel.setSize(10,10); // 총알 레이블 크기 설정
        bulletLabel.setOpaque(true); // 배경색을 표시하기 위해 true로 설정
        bulletLabel.setBackground(Color.RED); // 빨간색 배경 설정

        // 베이스, 타겟, 총알 레이블을 게임 패널에 추가
        add(baseLabel);
        add(targetLabel);
        add(bulletLabel);
    }

    // 게임 시작 메서드
    public void startGame() {
        baseLabel.setLocation(this.getWidth()/2-20, this.getHeight()-40); // 베이스 레이블 초기 위치 설정
        bulletLabel.setLocation(this.getWidth()/2 - 5, this.getHeight()-50); // 총알 레이블 초기 위치 설정
        targetLabel.setLocation(0, 0); // 타겟 레이블 초기 위치 설정

        targetThread = new TargetThread(targetLabel); // 타겟을 움직이는 스레드 생성
        targetThread.start(); // 타겟 스레드 시작

        baseLabel.setFocusable(true); // 베이스 레이블에 포커스 설정
        baseLabel.requestFocus(); // 베이스 레이블에 포커스 요청

        // 베이스 레이블에 키 리스너 추가
        baseLabel.addKeyListener(new KeyAdapter() {
            private BulletThread  bulletThread = null; // 총알 스레드

            // 키를 눌렀을 때 호출되는 메서드
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '\n') { // <Enter> 키가 눌리면
                    if(bulletThread == null || !bulletThread.isAlive()) { // 총알 스레드가 없거나 종료되었으면
                        bulletThread = new BulletThread(bulletLabel, targetLabel, targetThread); // 총알 스레드 생성
                        bulletThread.start(); // 총알 스레드 시작
                    }
                }
            }
        });
    }

    // 타겟을 움직이는 스레드 클래스
    class TargetThread extends Thread {
        private JComponent target; // 타겟 컴포넌트

        // 생성자
        public TargetThread(JComponent target) {
            this.target = target;
            target.setLocation(0, 0); // 타겟의 초기 위치 설정
            target.getParent().repaint(); // 부모 컨테이너 다시 그리기 요청
        }

        // 스레드 실행 메서드
        public void run() {
            while(true) { // 무한 루프
                int x = target.getX() + 5; // 타겟의 x 좌표 이동
                int y = target.getY(); // 타겟의 y 좌표는 그대로 유지
                if(x > GamePanel.this.getWidth()) // 타겟이 화면을 벗어나면
                    target.setLocation(0,0); // 초기 위치로 설정
                else
                    target.setLocation(x, y); // 타겟을 새 위치로 설정

                target.getParent().repaint(); // 부모 컨테이너 다시 그리기 요청
                try {
                    sleep(20); // 20밀리초 동안 스레드 일시 정지
                }
                catch(InterruptedException e) {
                    // 총알에 맞았을 경우
                    target.setLocation(0, 0); // 초기 위치로 설정
                    target.getParent().repaint(); // 부모 컨테이너 다시 그리기 요청
                    try {
                        sleep(500); // 0.5초 동안 대기
                    }
                    catch(InterruptedException e2) {}
                }
            }
        }
    }

    // 총알을 움직이는 스레드 클래스
    class BulletThread extends Thread {
        private JComponent bullet, target; // 총알과 타겟 컴포넌트
        private Thread targetThread; // 타겟 스레드

        // 생성자
        public BulletThread(JComponent bullet, JComponent target, Thread targetThread) {
            this.bullet = bullet;
            this.target = target;
            this.targetThread = targetThread;
        }

        // 스레드 실행 메서드
        public void run() {
            while(true) { // 무한 루프
                // 명중 여부 확인
                if(hit()) {
                    targetThread.interrupt(); // 타겟 스레드 인터럽트
                    bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50); // 총알 위치 초기화
                    return; // 스레드 종료
                }
                else {
                    int x = bullet.getX(); // 총알 x 좌표
                    int y = bullet.getY() - 5; // 총알 y 좌표 감소
                    if(y < 0) { // 화면을 벗어나면
                        bullet.setLocation(bullet.getParent().getWidth()/2 - 5, bullet.getParent().getHeight()-50); // 초기 위치로 설정
                        bullet.getParent().repaint(); // 부모 컨테이너 다시 그리기 요청
                        return; // 스레드 종료
                    }
                    bullet.setLocation(x, y); // 총알 새 위치로 설정
                    bullet.getParent().repaint(); // 부모 컨테이너 다시 그리기 요청
                }
                try {
                    sleep(20); // 20밀리초 동안 스레드 일시 정지
                }
                catch(InterruptedException e) {}
            }
        }

        // 총알이 타겟에 맞았는지 여부를 확인하는 메서드
        private boolean hit() {
            if(targetContains(bullet.getX(), bullet.getY()) ||
                    targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()) ||
                    targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY() + bullet.getHeight() - 1) ||
                    targetContains(bullet.getX(), bullet.getY() + bullet.getHeight() - 1))
				return true; // 총알이 타겟에 맞았으면 true 반환
			else
					return false; // 총알이 타겟에 맞지 않았으면 false 반환
			}
	
			// 주어진 좌표가 타겟 내부에 포함되는지 여부를 확인하는 메서드
			private boolean targetContains(int x, int y) {
				if(((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) &&
						((target.getY() <= y) && (target.getY() + target.getHeight() - 1 >= y))) {
					return true; // 주어진 좌표가 타겟 내부에 포함되면 true 반환
				} else {
					return false; // 포함되지 않으면 false 반환
				}
			}
		}
	}
	