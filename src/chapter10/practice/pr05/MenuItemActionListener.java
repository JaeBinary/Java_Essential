package chapter10.practice.pr05;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.*;

public class MenuItemActionListener extends JFrame {
    private JTextArea ta = new JTextArea(); // 텍스트를 입력할 JTextArea 객체 선언

    public MenuItemActionListener() {
        super("파일 저장"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        createMenu(); // 메뉴를 생성하는 메서드 호출
        Container c = getContentPane(); // 컨텐트 팬 가져오기
        c.add(new JScrollPane(ta)); // JTextArea를 스크롤 가능하게 하여 컨텐트 팬에 추가
        setSize(300, 200); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    private void createMenu() {
        JMenu fileMenu = new JMenu("파일"); // "파일" 메뉴 생성
        JMenuItem save = new JMenuItem("저장"); // "저장" 메뉴 아이템 생성
        fileMenu.add(save); // "파일" 메뉴에 "저장" 메뉴 아이템 추가

        // "저장" 메뉴 아이템에 대한 ActionListener 설정
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ta.getText().length() == 0) { // JTextArea에 입력된 텍스트가 없는 경우
                    JOptionPane.showMessageDialog(MenuItemActionListener.this,
                            "입력된 내용이 없습니다.",
                            "Warning", JOptionPane.WARNING_MESSAGE); // 경고 메시지 출력
                    return;
                }

                String fileName = JOptionPane.showInputDialog(MenuItemActionListener.this,
                        "저장할 파일명을 입력하세요"); // 사용자로부터 파일명 입력 받기
                if (fileName == null) { // 파일명이 입력되지 않은 경우
                    JOptionPane.showMessageDialog(MenuItemActionListener.this,
                            "파일을 저장하지 않습니다.",
                            "Warning", JOptionPane.WARNING_MESSAGE); // 경고 메시지 출력
                    return;
                }

                try {
                    FileWriter fout = new FileWriter(fileName); // FileWriter를 이용해 파일 생성
                    String t = ta.getText(); // JTextArea에 입력된 전체 텍스트 가져오기
                    StringTokenizer st = new StringTokenizer(t, "\n"); // 텍스트를 라인 단위로 분리하는 StringTokenizer 생성
                    while (st.hasMoreTokens()) {
                        fout.write(st.nextToken()); // 한 라인씩 파일에 쓰기
                        fout.write("\r\n"); // 줄 바꿈 문자 추가
                    }
                    fout.close(); // 파일 스트림 닫기
                } catch (IOException e1) {
                    // 파일 저장 중 오류가 발생한 경우 처리하지 않음
                }
            }
        });

        JMenuBar mb = new JMenuBar(); // 메뉴 바 생성
        mb.add(fileMenu); // 메뉴 바에 "파일" 메뉴 추가
        setJMenuBar(mb); // 프레임에 메뉴 바 설정
    }

    public static void main(String[] args) {
        new MenuItemActionListener(); // MenuItemActionListener 객체 생성하여 실행
    }
}
