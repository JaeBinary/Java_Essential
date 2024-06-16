package chapter14.practice.pr04;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WordChainClient {
    private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;

    public WordChainClient() { }

    // 클라이언트 실행 메소드
    public void run() {
        System.out.println("끝말잇기 클라이언트입니다.");
        setupConnection(); // 서버와의 연결 설정
        System.out.println("끝말잇기 게임 서버에 접속하였습니다.");

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                String serverWord = in.readLine(); // 서버로부터 단어 수신
                if (serverWord.equals("win")) {
                    System.out.print("클라이언트가 이겼습니다.");
                    break;
                }

                System.out.println("서버>> " + serverWord);
                System.out.print("클라이언트>> ");
                String clientWord = scanner.next(); // 사용자로부터 단어 입력
                if (clientWord.equals("그만")) {
                    System.out.println("프로그램을 종료합니다...");
                    break;
                }
                out.write(clientWord + "\n"); // 서버로 단어 전송
                out.flush();

                String result = in.readLine(); // 서버로부터 결과 수신
                if (result.equals("YES"))
                    continue; // 서버로부터 "YES"를 받으면 게임 계속
                else {
                    System.out.print("클라이언트가 졌습니다.");
                    break; // 서버로부터 "NO"를 받으면 게임 종료
                }
            }
        } catch (IOException e1) {
            System.out.println("서버로부터 연결이 종료되었습니다...");
        }
        scanner.close(); // 스캐너 닫기
    }

    // 서버와의 연결 설정 메소드
    public void setupConnection() {
        try {
            socket = new Socket("localhost", 9998); // 서버에 연결 시도
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력 스트림 초기화
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 출력 스트림 초기화
        } catch (UnknownHostException e) {
            System.out.println("서버의 주소가 잘못되었습니다...");
            System.exit(0); // 서버 주소가 잘못되었을 경우 프로그램 종료
        } catch (IOException e) {
            System.out.println("서버가 꺼져 있는 등으로 서버에 연결할 수 없습니다...");
            System.exit(0); // 서버에 연결할 수 없을 경우 프로그램 종료
        }
    }

    public static void main(String[] args) {
        WordChainClient checkerClient = new WordChainClient();
        checkerClient.run(); // 클라이언트 실행
    }
}
