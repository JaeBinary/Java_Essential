package chapter11.practice.pr05; 					// chapter11.practice.pr05 패키지에 속하는 클래스임을 명시
import java.awt.*; 									// java.awt 패키지의 모든 클래스를 임포트
import java.awt.event.*; 							// java.awt 이벤트 관련 패키지를 임포트
import java.util.*; 								// java.util 패키지의 모든 클래스를 임포트
import javax.swing.*; 								// javax.swing 패키지의 모든 클래스를 임포트

// DrawPolygonWithMouse 클래스는 JFrame을 상속받는다.
public class DrawPolygonWithMouse extends JFrame {
    
    // DrawPolygonWithMouse 생성자
    public DrawPolygonWithMouse() {
        super("마우스로 폐다각형 그리기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭했을 때 프로그램이 종료되도록 설정
        setContentPane(new MyPanel()); // 새로운 패널(MyPanel)을 생성하여 컨텐트팬으로 설정
        setSize(300, 300); // 프레임의 크기를 가로 300, 세로 300으로 설정
        setVisible(true); // 프레임을 화면에 보이도록 설정
    }

    // MyPanel 클래스는 JPanel을 상속받는다.
    class MyPanel extends JPanel {
        private Vector<Integer> x = new Vector<Integer>(); // x 좌표를 저장할 벡터
        private Vector<Integer> y = new Vector<Integer>(); // y 좌표를 저장할 벡터

        // MyPanel 생성자
        public MyPanel() {
            // 마우스 클릭 이벤트 리스너 등록
            this.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    x.add(e.getX()); // 마우스 클릭 시 x 좌표를 벡터에 추가
                    y.add(e.getY()); // 마우스 클릭 시 y 좌표를 벡터에 추가
                    repaint(); // 패널 다시 그리기 요청
                }
            });
        }

        // paintComponent 메서드 오버라이딩
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // 부모 클래스(JPanel)의 paintComponent 메서드 호출
            g.setColor(Color.MAGENTA); // 폐다각형의 색상을 마젠타로 설정
            
            // 벡터의 좌표를 배열로 변환
            int xs[] = new int[x.size()];
            int ys[] = new int[y.size()];
            for (int i = 0; i < x.size(); i++) {
                xs[i] = x.get(i);
                ys[i] = y.get(i);
            }

            // 배열에 저장된 좌표를 사용하여 폐다각형을 그린다.
            g.drawPolygon(xs, ys, xs.length);
        }
    }

    // main 메서드: 프로그램의 시작점
    static public void main(String[] args) {
        new DrawPolygonWithMouse(); // DrawPolygonWithMouse 객체를 생성하여 프로그램을 실행
    }
}
