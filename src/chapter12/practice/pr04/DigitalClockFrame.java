package chapter12.practice.pr04;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class DigitalClockFrame extends JFrame {
    public DigitalClockFrame() {
        setTitle("디지털 시계 만들기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기 버튼 설정

        getContentPane().add(new DigitalClockLabel()); // DigitalClockLabel을 콘텐츠 팬에 추가
        setSize(250,200); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    // 디지털 시계를 표시하는 JLabel을 생성하고 스레드를 이용해 시간을 업데이트하는 내부 클래스
    class DigitalClockLabel extends JLabel implements Runnable {
        public DigitalClockLabel() {
            setText(makeClockText()); // 현재 시간으로 텍스트 초기화
            setFont(new Font("TimesRoman", Font.ITALIC, 50)); // 폰트 설정
            setHorizontalAlignment(JLabel.CENTER); // 텍스트 정렬 설정
            new Thread(this).start(); // 스레드 시작
        }

        // 현재 시간을 문자열로 반환하는 메서드
        public String makeClockText() {
            Calendar c = Calendar.getInstance(); // 현재 시간을 가져오는 Calendar 객체 생성
            int hour = c.get(Calendar.HOUR_OF_DAY); // 시간 (24시간 형식)
            int min = c.get(Calendar.MINUTE); // 분
            int second = c.get(Calendar.SECOND); // 초

            // 시간을 시:분:초 형식으로 문자열로 변환
            String clockText = Integer.toString(hour);
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(min));
            clockText = clockText.concat(":");
            clockText = clockText.concat(Integer.toString(second));

            return clockText;
        }

        // 스레드가 실행할 메서드
        public void run() {
            while(true) { // 무한 루프
                try {
                    Thread.sleep(1000); // 1초마다
                }
                catch(InterruptedException e) {
                    return; // 인터럽트 예외 발생 시 스레드 종료
                }
                setText(makeClockText()); // 시계 텍스트를 업데이트하여 JLabel에 설정
            }
        }
    }

    // 메인 메서드에서 프레임 생성
    public static void main(String[] args) {
        new DigitalClockFrame();
    }
}
