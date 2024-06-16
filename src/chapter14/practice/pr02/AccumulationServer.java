package chapter14.practice.pr02;
import java.io.*;
import java.net.*;

public class AccumulationServer {
    public static void main(String[] args) {
        BufferedReader in = null; // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 선언
        ServerSocket listener = null; // 클라이언트의 연결 요청을 기다리는 서버 소켓 선언
        Socket socket = null; // 클라이언트와의 통신을 위한 소켓 선언

        int sum = 0; // 클라이언트로부터 받은 정수를 합하여 누적 저장하는 변수
        System.out.println("서버입니다. 클라이언트를 기다립니다...");
        try {
            listener = new ServerSocket(9999); // 서버 소켓 생성, 포트 9999에서 클라이언트의 연결을 대기
            socket = listener.accept(); // 클라이언트로부터 연결 요청을 수락
            System.out.println("연결되었습니다.");

            // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 초기화
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputMessage;
            while (true) {
                inputMessage = in.readLine(); // 클라이언트로부터 한 행의 텍스트를 읽음
                int n = Integer.parseInt(inputMessage); // 읽은 문자열을 정수로 변환
                if (n < 0) { // 클라이언트가 음수를 보내면 연결 종료
                    System.out.println("서버를 종료합니다.");
                    break; // 루프를 빠져나옴
                }

                sum += n; // 클라이언트로부터 받은 정수를 누적
                System.out.println("누적합 " + sum); // 누적합을 화면에 출력
            }
            socket.close(); // 클라이언트와의 통신용 소켓 닫기
            listener.close(); // 서버 소켓 닫기
        } catch (IOException e) {
            // 입출력 오류 발생 시 예외 처리
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}
