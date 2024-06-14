package chapter14;
import java.io.*;
import java.net.*;
import java.util.*;

public class CalcServerEx {

    // 수식을 계산하는 메서드
    public static String calc(String exp) {
        StringTokenizer st = new StringTokenizer(exp, " "); 								// 수식을 공백을 기준으로 분리하는 StringTokenizer 생성
        if (st.countTokens() != 3) return "error"; 												// 피연산자와 연산자를 제대로 분리하지 못한 경우 오류 반환

        String res = "";
        int op1 = Integer.parseInt(st.nextToken()); 											// 첫 번째 피연산자
        String opcode = st.nextToken(); 														// 연산자
        int op2 = Integer.parseInt(st.nextToken()); 											// 두 번째 피연산자
        switch (opcode) {
            case "+": res = Integer.toString(op1 + op2); 										// 덧셈 연산
                break;
            case "-": res = Integer.toString(op1 - op2); 										// 뺄셈 연산
                break;
            case "*": res = Integer.toString(op1 * op2); 										// 곱셈 연산
                break;
            default : res = "error"; 															// 알 수 없는 연산자인 경우 오류 반환
        }
        return res; 																			// 계산 결과 반환
    }

    // 서버 메인 메서드
    public static void main(String[] args) {
        BufferedReader in = null; 																// 클라이언트로부터의 입력을 받기 위한 BufferedReader
        BufferedWriter out = null; 																// 클라이언트로의 출력을 위한 BufferedWriter
        ServerSocket listener = null; 															// 클라이언트의 연결을 받기 위한 ServerSocket
        Socket socket = null; 																	// 통신을 위한 Socket
        try {
            listener = new ServerSocket(9999); 											// 포트 9999에서 클라이언트의 연결 요청을 받을 ServerSocket 생성
            System.out.println("연결을 기다리고 있습니다.....");
            socket = listener.accept(); 														// 클라이언트의 연결 요청을 기다리고, 연결을 수락하여 Socket 생성
            System.out.println("연결되었습니다.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 			// 소켓 입력 스트림
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 		// 소켓 출력 스트림
            while (true) {
                String inputMessage = in.readLine(); 											// 클라이언트로부터 수식을 입력받음
                if (inputMessage.equalsIgnoreCase("bye")) {
                    System.out.println("클라이언트에서 연결을 종료하였음"); 						 // "bye" 메시지를 받으면 연결 종료 메시지 출력
                    break; 																		// 연결 종료
                }
                System.out.println(inputMessage); 												// 받은 메시지를 콘솔에 출력
                String res = calc(inputMessage); 												// 입력받은 수식을 계산하여 결과를 받음
                out.write(res + "\n"); 															// 계산 결과를 클라이언트에게 전송
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage()); 												// 입출력 예외 발생 시 메시지 출력
        } finally {
            try {
                if (socket != null) socket.close(); 											// 소켓 닫기
                if (listener != null) listener.close(); 										// 서버 소켓 닫기
            } catch (IOException e) {
                System.out.println("클라이언트와의 연결 해제 중 오류가 발생했습니다."); 			   // 예외 발생 시 메시지 출력
            }
        }
    }
}
