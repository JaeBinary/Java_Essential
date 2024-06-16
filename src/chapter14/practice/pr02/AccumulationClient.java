package chapter14.practice.pr02;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AccumulationClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 키보드 입력을 받기 위한 Scanner 객체 생성
        BufferedWriter out = null; // 서버로 데이터를 전송하기 위한 출력 스트림 선언
        Socket socket = null; // 서버와의 연결을 위한 소켓 선언
        try {
            socket = new Socket("localhost", 9999); // 클라이언트 소켓 생성. 지정된 서버와 포트에 바로 접속
            System.out.println("서버에 접속하였습니다..."); // 서버 접속 성공 메시지 출력
            
            // 서버로 데이터를 전송하기 위한 출력 스트림 초기화
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String outputMessage;
            while (true) {
                System.out.print("보낼 정수 입력 >> "); // 사용자에게 정수 입력 요청
                outputMessage = scanner.nextLine(); // 키보드에서 한 행의 문자열을 입력받음
                
                try {
                    int n = Integer.parseInt(outputMessage); // 입력받은 문자열을 정수로 변환. 숫자가 아니면 NumberFormatException 발생
                    
                    // 서버로 메시지 전송. outputMessage가 숫자가 아니면 NumberFormatException이 발생하여 이 코드는 실행되지 않음
                    out.write(outputMessage + "\n");
                    out.flush(); // 출력 스트림을 비움
                    if (n < 0) { // 음수가 입력되면 서버와의 연결을 종료
                        System.out.println("연결을 종료합니다.");
                        break; // 루프를 빠져나옴
                    }
                } catch (NumberFormatException e) {
                    // 입력된 문자열이 숫자가 아닐 경우 예외 처리
                    System.out.println("오류. 다시 입력 >> "); // 오류 메시지 출력
                    continue; // 루프의 처음으로 돌아가 다시 입력받음
                }
            }
            // 연결 종료. 클라이언트 소켓 닫기
            socket.close();
            scanner.close();
        } catch (IOException e) {
            // 입출력 오류 발생 시 예외 처리
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}
