package chapter10.practice.pr02;
import javax.swing.*;

public class SimpleMenuFrame extends JFrame {
    public SimpleMenuFrame() {
        super("메뉴 만들기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        
        createMenu(); // 메뉴를 생성하는 메소드 호출
        
        setSize(300, 150); // 프레임의 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }
    
    private void createMenu() {
        // 메뉴 아이템들을 포함할 각각의 메뉴 생성
        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        
        // 보기 메뉴에 메뉴 아이템 추가
        viewMenu.add(new JMenuItem("화면확대"));
        viewMenu.addSeparator(); // 분리선 추가
        viewMenu.add(new JMenuItem("쪽윤곽"));
        
        JMenu inputMenu = new JMenu("입력"); // 입력 메뉴 생성
        
        JMenuBar mb = new JMenuBar(); // 메뉴 바 생성
        mb.add(fileMenu); // 메뉴 바에 파일 메뉴 추가
        mb.add(editMenu); // 메뉴 바에 편집 메뉴 추가
        mb.add(viewMenu); // 메뉴 바에 보기 메뉴 추가
        mb.add(inputMenu); // 메뉴 바에 입력 메뉴 추가
        
        setJMenuBar(mb); // 프레임에 메뉴 바 설정
    }
    
    public static void main(String[] args) {
        new SimpleMenuFrame(); // SimpleMenuFrame 객체 생성하여 실행
    }
}
