package chapter10.practice.pr01;
import java.awt.*;
import javax.swing.*;

public class FourImageFrame extends JFrame {
    public FourImageFrame() {
        super("4 Images"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임이 닫힐 때 프로그램 종료 설정
        Container c = getContentPane(); // 컨텐트 팬 가져오기
        c.setLayout(new GridLayout(1, 4, 10, 10)); // 1행 4열 그리드 레이아웃 설정 (간격 10)

        // 이미지 아이콘 배열 선언 및 초기화
        ImageIcon img[] = new ImageIcon[4];
        img[0] = new ImageIcon("images/practice/10-01/img1.jpg"); // images 폴더의 img1.jpg 파일을 이미지 아이콘으로 설정
        img[1] = new ImageIcon("images/practice/10-01/img2.jpg"); // images 폴더의 img2.jpg 파일을 이미지 아이콘으로 설정
        img[2] = new ImageIcon("images/practice/10-01/img3.jpg"); // images 폴더의 img3.jpg 파일을 이미지 아이콘으로 설정
        img[3] = new ImageIcon("images/practice/10-01/img4.jpg"); // images 폴더의 img4.jpg 파일을 이미지 아이콘으로 설정

        for (int i = 0; i < img.length; i++) {
            c.add(new JLabel(img[i])); // 이미지 아이콘을 레이블에 추가하여 컨텐트 팬에 붙이기
        }

        setSize(500, 200); // 프레임 크기 설정
        setVisible(true); // 프레임을 보이도록 설정
    }

    public static void main(String[] args) {
        new FourImageFrame(); // FourImageFrame 객체 생성하여 실행
    }
}
