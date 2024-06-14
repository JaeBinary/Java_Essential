package chapter09.practice.prBonus02;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * CalculatorFrame 클래스는 간단한 계산기를 구현하는 프레임입니다.
 */
public class CalculatorFrame extends JFrame {
    private CenterPanel centerPanel = new CenterPanel(); // 계산기의 중앙 패널
    private NorthPanel northPanel = new NorthPanel(); // 계산기의 상단 패널

    /**
     * CalculatorFrame의 생성자입니다.
     * 프레임의 제목 설정 및 컴포넌트 배치를 수행합니다.
     */
    public CalculatorFrame() {
        super("간단한 계산기"); // 프레임의 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼 동작 설정

        Container c = getContentPane(); // 프레임의 컨텐트팬을 가져옴

        c.add(centerPanel, BorderLayout.CENTER); // 중앙 패널을 프레임의 중앙에 추가
        c.add(northPanel, BorderLayout.NORTH); // 상단 패널을 프레임의 북쪽에 추가

        setSize(270, 250); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    /**
     * CenterPanel 클래스는 계산기의 숫자 및 연산자 버튼을 가지고 있는 패널입니다.
     */
    class CenterPanel extends JPanel {
        private JButton b[] = { new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/") };
        private JButton ceBtn = new JButton("CE");
        private JButton calBtn = new JButton("계산");
        private boolean waitForNewCalc = true; // 새 계산을 기다리는 플래그

        /**
         * CenterPanel의 생성자입니다. 숫자 버튼, CE 버튼, 계산 버튼을 생성하고 이벤트 리스너를 설정합니다.
         */
        public CenterPanel() {
            setBackground(Color.WHITE); // 배경색 설정
            setLayout(new GridLayout(4, 4, 5, 5)); // 그리드 레이아웃으로 설정

            // 숫자 버튼 추가
            for (int i = 0; i < 10; i++) {
                JButton b = new JButton(Integer.toString(i));
                add(b);

                // 숫자 버튼 클릭 시 처리
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (waitForNewCalc) {
                            waitForNewCalc = false;
                            northPanel.clear(); // 수식창 초기화
                        }
                        northPanel.attachExp(e.getActionCommand()); // 클릭한 버튼의 숫자를 수식창에 추가
                    }
                });
            }

            // 연산자 버튼 추가
            for (int i = 0; i < b.length; i++) {
                b[i].setBackground(Color.CYAN);
                add(b[i]);

                // 연산자 버튼 클릭 시 처리
                b[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (waitForNewCalc) {
                            waitForNewCalc = false;
                            northPanel.clear(); // 수식창 초기화
                        }
                        northPanel.attachExp(e.getActionCommand()); // 클릭한 버튼의 연산자를 수식창에 추가
                    }
                });
            }

            // CE 버튼 클릭 시 처리
            ceBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    northPanel.clear(); // 수식창 초기화
                }
            });

            // 계산 버튼 클릭 시 처리
            calBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    northPanel.calculate(); // 수식 계산
                    waitForNewCalc = true; // 새 계산을 기다리도록 설정
                }
            });

            add(ceBtn); // CE 버튼 추가
            add(calBtn); // 계산 버튼 추가
        }
    }

    /**
     * NorthPanel 클래스는 계산기의 상단에 있는 수식과 결과를 표시하는 패널입니다.
     */
    class NorthPanel extends JPanel {
        private JTextField exp = new JTextField(10); // 수식을 입력받는 텍스트 필드
        private JTextField res = new JTextField(8); // 결과를 표시하는 텍스트 필드

        /**
         * NorthPanel의 생성자입니다. 수식과 결과를 표시할 텍스트 필드를 초기화하고 패널을 구성합니다.
         */
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY); // 배경색 설정
            setOpaque(true); // 투명도 설정
            setLayout(new FlowLayout()); // FlowLayout으로 설정

            add(new JLabel("수식")); // "수식" 레이블 추가
            add(exp); // 수식 입력 텍스트 필드 추가
            add(new JLabel("결과")); // "결과" 레이블 추가
            add(res); // 결과 표시 텍스트 필드 추가
        }

        /**
         * 수식 입력 텍스트 필드와 결과 텍스트 필드를 초기화하는 메소드입니다.
         */
        public void clear() {
            exp.setText(""); // 수식 텍스트 필드 초기화
            res.setText(""); // 결과 텍스트 필드 초기화
        }

        /**
         * 수식을 계산하고 결과를 결과 텍스트 필드에 출력하는 메소드입니다.
         */
        public void calculate() {
            String text = exp.getText(); // 수식 입력 텍스트 필드에서 수식 가져오기
            StringTokenizer st = new StringTokenizer(text, "+-x/"); // 수식을 연산자로 분리하기 위해 StringTokenizer 사용

            // 연산자가 2개가 아니면 잘못된 수식으로 처리
            if (st.countTokens() != 2) {
                exp.setText("잘못된 수식");
                return;
            }

            int op1 = 0, op2 = 0;
            try {
                op1 = Integer.parseInt(st.nextToken()); // 첫 번째 숫자 가져오기
                op2 = Integer.parseInt(st.nextToken()); // 두 번째 숫자 가져오기
            } catch (NumberFormatException e) {
                exp.setText("잘못된 수식");
                return;
            }

            // 연산자 알아내기
            int index = text.indexOf(Integer.toString(op2)); // 두 번째 숫자 시작 위치 찾기
            String operator = text.substring(index - 1, index); // 두 번째 숫자 앞의 연산자 가져오기

            double r = 0;
            switch (operator) {
                case "+":
                    r = op1 + op2;
                    break;
                case "-":
                    r = op1 - op2;
                    break;
                case "x":
                    r = op1 * op2;
                    break;
                case "/":
                    if (op2 == 0) {
                        exp.setText("0으로 나눌 수 없음");
                        return;
                    }
                    r = (double) op1 / op2; // 실수로 나눗셈 결과 계산
                    break;
            }

            res.setText(Double.toString(r)); // 계산 결과를 결과 텍스트 필드에 출력
        }

        /**
         * 수식 입력 텍스트 필드에 문자열을 추가하는 메소드입니다.
         */
        public void attachExp(String s) {
            String text = exp.getText();
            text += s;
            exp.setText(text);
        }
    }

    /**
     * 프로그램의 시작점인 main 메소드입니다.
     * CalculatorFrame 인스턴스를 생성하여 계산기 프레임을 표시합니다.
     */
    public static void main(String[] args) {
        new CalculatorFrame();
    }

}
