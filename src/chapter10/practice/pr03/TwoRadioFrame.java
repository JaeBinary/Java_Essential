package chapter10.practice.pr03;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoRadioFrame extends JFrame {
    private JRadioButton red = new JRadioButton("Red"); // "Red" 라디오 버튼 생성
    private JRadioButton blue = new JRadioButton("Blue"); // "Blue" 라디오 버튼 생성

    public TwoRadioFrame() {
        super("Two Radio Frame"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        Container c = getContentPane(); // 컨텐트 팬 가져오기
        c.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정
        
        ButtonGroup g = new ButtonGroup(); // 라디오 버튼 그룹 생성
        g.add(red); // 그룹에 "Red" 라디오 버튼 추가
        g.add(blue); // 그룹에 "Blue" 라디오 버튼 추가

        c.add(red); // 컨텐트 팬에 "Red" 라디오 버튼 추가
        c.add(blue); // 컨텐트 팬에 "Blue" 라디오 버튼 추가

        MyItemListener listener = new MyItemListener(); // 아이템 리스너 객체 생성
        red.addItemListener(listener); // "Red" 라디오 버튼에 리스너 추가
        blue.addItemListener(listener); // "Blue" 라디오 버튼에 리스너 추가

        setSize(250, 100); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    // 아이템 리스너 내부 클래스 정의
    class MyItemListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() != ItemEvent.SELECTED)
                return;
            if (e.getItem() == red) { // 선택된 아이템이 "Red" 라디오 버튼인 경우
                getContentPane().setBackground(Color.RED); // 프레임의 배경색을 빨강으로 설정
            } else if (e.getItem() == blue) { // 선택된 아이템이 "Blue" 라디오 버튼인 경우
                getContentPane().setBackground(Color.BLUE); // 프레임의 배경색을 파랑으로 설정
            }
        }
    }

    public static void main(String[] args) {
        new TwoRadioFrame(); // TwoRadioFrame 객체 생성하여 실행
    }
}
