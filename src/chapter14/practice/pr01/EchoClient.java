package chapter14.practice.pr01;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 스캐너 객체 생성
		BufferedWriter out = null; // 서버로 데이터를 보내기 위한 출력 스트림 선언
		Socket socket = null; // 서버와의 연결을 위한 소켓 선언
		try {
			// localhost의 9999번 포트에 서버가 있다고 가정하고 소켓 생성하여 연결 시도
			socket = new Socket("localhost", 9999); 
			System.out.println("서버에 접속하였습니다...");
			
			// 서버로의 출력 스트림 초기화 (BufferedWriter를 통해 데이터 전송)
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String outputMessage;
			while (true) {
				// 사용자로부터 텍스트 입력받기
				System.out.print("텍스트 입력 >> ");
				outputMessage = scanner.nextLine(); // 키보드에서 한 행의 문자열 읽음
				out.write(outputMessage + "\n"); // 서버로 문자열 전송
				out.flush(); // 버퍼에 있는 데이터를 강제로 출력 스트림에 쓰기
				if (outputMessage.equalsIgnoreCase("끝")) { // "끝"이 입력되면 서버와 연결 종료
					System.out.println("연결을 종료합니다.");
					break;
				}
			}
			// 소켓 및 스캐너 자원 해제
			socket.close(); // 연결 종료. 클라이언트 소켓 닫기
			scanner.close(); // 스캐너 닫기
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다."); // 입출력 오류 발생 시 메시지 출력
		}
	}
}
