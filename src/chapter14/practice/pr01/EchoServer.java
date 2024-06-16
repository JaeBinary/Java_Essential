package chapter14.practice.pr01;
import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        BufferedReader in = null; // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 선언
        ServerSocket listener = null; // 클라이언트의 연결을 기다리기 위한 서버 소켓 선언
        Socket socket = null; // 클라이언트와의 통신을 위한 소켓 선언
        System.out.println("서버입니다. 클라이언트를 기다립니다..."); // 서버 시작 메시지 출력
        try {
            listener = new ServerSocket(9999); // 9999번 포트에서 클라이언트의 연결을 기다리기 위한 서버 소켓 생성
            socket = listener.accept(); // 클라이언트의 연결 요청을 수락
            System.out.println("연결되었습니다."); // 클라이언트와 연결되었음을 알리는 메시지 출력
            
            // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 초기화
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputMessage;
            while (true) {
                inputMessage = in.readLine(); // 클라이언트로부터 한 행의 텍스트를 읽음
                if (inputMessage.equals("끝")) { // 클라이언트가 "끝"이라고 보냈을 경우
                    System.out.println("서버를 종료합니다."); // 서버 종료 메시지 출력
                    break; // 루프를 빠져나와 서버 종료
                }
                // 클라이언트로부터 받은 메시지를 화면에 출력
                System.out.println("... " + inputMessage);
            }
            socket.close(); // 클라이언트와의 통신용 소켓 닫기
            listener.close(); // 서버 소켓 닫기
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다."); // 입출력 오류 발생 시 메시지 출력
        }
    }
}
