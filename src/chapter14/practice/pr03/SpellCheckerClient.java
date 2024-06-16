package chapter14.practice.pr03;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SpellCheckerClient {
	private Socket socket = null; // 서버와의 통신을 위한 소켓
	private BufferedReader in = null; // 서버로부터의 입력 스트림
	private BufferedWriter out = null; // 서버로의 출력 스트림
	
	public SpellCheckerClient() { } // 기본 생성자
	
	public void run() {
		System.out.println("스펠체크 클라이언트입니다.");
		setupConnection(); // 서버와의 연결 설정
		System.out.println("스펠체크 서버에 접속하였습니다.");		
		
		Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 스캐너
		String word;
		while(true) {
			try {
				System.out.print("단어 >> ");
				word = scanner.next(); // 사용자로부터 단어 입력 받기
				if(word.equals("그만")) { // "그만"을 입력하면 프로그램 종료
					System.out.println("프로그램을 종료합니다...");
					break;
				}
				out.write(word + "\n"); // 입력받은 단어를 서버로 전송
				out.flush(); // 출력 스트림을 비움 (즉, 서버로 데이터 전송)
					
				String result = in.readLine(); // 서버로부터 스펠체크 결과 받기
				System.out.println(result); // 결과 출력
			} catch (IOException e1) {
				// 서버와의 연결이 종료되었을 때 예외 처리
				System.out.println("서버로부터 연결이 종료되었습니다...");
				break;
			}
		}
		scanner.close(); // 스캐너 닫기
	}
	
	// 서버와의 연결 설정
	public void setupConnection() {
		try {
			socket = new Socket("localhost", 9998); // 서버 소켓 생성 및 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 서버로부터의 입력 스트림 초기화
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 서버로의 출력 스트림 초기화
		} catch (UnknownHostException e) {
			// 호스트를 찾지 못했을 때 예외 처리
			e.printStackTrace();
		} catch (IOException e) {
			// 입출력 오류 발생 시 예외 처리
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SpellCheckerClient checkerClient = new SpellCheckerClient(); // SpellCheckerClient 객체 생성
		checkerClient.run(); // 클라이언트 실행
	}
}
