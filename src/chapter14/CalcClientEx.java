package chapter14;
import java.io.*;
import java.net.*;
import java.util.*;

public class CalcClientEx {
    public static void main(String[] args) {
        BufferedReader in = null; 																// 서버로부터의 입력을 받기 위한 BufferedReader
        BufferedWriter out = null; 																// 서버로의 출력을 위한 BufferedWriter
        Socket socket = null; 																	// 클라이언트 소켓
        Scanner scanner = new Scanner(System.in); 												// 키보드 입력을 받기 위한 Scanner 객체 생성
        try {
            socket = new Socket("localhost", 9999); 									// 서버에 접속을 시도하는 소켓 생성
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 			// 소켓 입력 스트림
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 		// 소켓 출력 스트림
            while (true) {
                System.out.print("계산식(빈칸으로 띄어 입력,예:24 + 42)>>"); 						// 사용자에게 입력 프롬프트 제공
                String outputMessage = scanner.nextLine(); 										// 사용자로부터 계산식을 입력받음
                if (outputMessage.equalsIgnoreCase("bye")) { 						// 사용자가 "bye"를 입력한 경우
                    out.write(outputMessage + "\n"); 											// 서버에 "bye"를 전송
                    out.flush();
                    break; 																		// 연결 종료
                }
                out.write(outputMessage + "\n"); 												// 계산식을 서버에 전송
                out.flush();
                String inputMessage = in.readLine(); 											// 서버로부터 계산 결과를 읽어옴
                System.out.println("계산 결과: " + inputMessage); 								 // 계산 결과 출력
            }
        } catch (IOException e) { 																// 입출력 예외 처리
            System.out.println(e.getMessage()); 												// 예외 메시지 출력
        } finally {
            try {
                scanner.close(); 																// Scanner 객체 닫기
                if (socket != null) socket.close(); 											// 소켓 닫기
            } catch (IOException e) {
                System.out.println("서버와의 연결 해제 중 오류가 발생했습니다."); 				  // 예외 발생 시 메시지 출력
            }
        }
    }
}
