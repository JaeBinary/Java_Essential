package chapter10.practice.pr04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxPracticeFrame extends JFrame {
    private JButton btn = new JButton("test button"); // "test button" 텍스트를 가진 JButton 객체 생성

    public CheckBoxPracticeFrame() {
        super("CheckBox와 Item 이벤트 Frame"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        Container c = getContentPane(); // 컨텐트 팬 가져오기
        c.setLayout(new FlowLayout()); // FlowLayout으로 레이아웃 설정

        JCheckBox a = new JCheckBox("버튼 비활성화"); // "버튼 비활성화"라는 텍스트를 가진 체크박스 생성
        JCheckBox b = new JCheckBox("버튼 감추기"); // "버튼 감추기"라는 텍스트를 가진 체크박스 생성

        c.add(a); // 체크박스 a를 컨텐트 팬에 추가
        c.add(b); // 체크박스 b를 컨텐트 팬에 추가
        c.add(btn); // 버튼을 컨텐트 팬에 추가

        // 체크박스 a의 상태 변경 리스너 설정
        a.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    btn.setEnabled(false); // 체크되면 버튼 비활성화
                } else {
                    btn.setEnabled(true); // 체크 해제되면 버튼 활성화
                }
            }
        });

        // 체크박스 b의 상태 변경 리스너 설정
        b.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    btn.setVisible(false); // 체크되면 버튼 숨기기
                } else {
                    btn.setVisible(true); // 체크 해제되면 버튼 보이기
                }
            }
        });

        setSize(250, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    public static void main(String[] args) {
        new CheckBoxPracticeFrame(); // CheckBoxPracticeFrame 객체 생성하여 실행
    }
}
