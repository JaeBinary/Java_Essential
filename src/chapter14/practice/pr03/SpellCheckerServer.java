package chapter14.practice.pr03;
import java.io.*;
import java.net.*;
import java.util.*;

public class SpellCheckerServer {
    private SpellChecker spellChecker;

    public SpellCheckerServer() { }

    public void run() {
        System.out.println("스펠체크 서버입니다.");
        spellChecker = new SpellChecker("words.txt"); // 단어 목록 파일을 읽어 SpellChecker 초기화
        if (spellChecker.isFileRead()) { // 단어 파일이 성공적으로 읽혀졌는지 확인
            System.out.println("words.txt 읽기 완료");
            new ServerThread().start(); // 클라이언트 요청을 처리할 서버 스레드 시작
        }
    }

    // 클라이언트의 접속을 기다리는 서버 스레드
    class ServerThread extends Thread {
        @Override
        public void run() {
            ServerSocket listener = null;
            Socket socket = null;
            try {
                listener = new ServerSocket(9998); // 서버 소켓 생성
                while (true) {
                    socket = listener.accept(); // 클라이언트의 연결 요청 대기
                    System.out.println("클라이언트 연결됨");
                    new ServiceThread(socket).start(); // 클라이언트 요청을 처리할 서비스 스레드 생성 및 시작
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            // 소켓 종료
            try {
                if (listener != null)
                    listener.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 단어의 스펠링을 검사하는 클래스
    class SpellChecker {
        private Vector<String> v = new Vector<String>(); // 파일로부터 읽은 단어를 저장하는 벡터
        private boolean fileOn = false; // 파일이 제대로 읽혔는지 여부를 저장하는 변수

        public SpellChecker(String fileName) {
            try {
                Scanner reader = new Scanner(new FileReader(fileName)); // 파일을 읽기 위한 스캐너
                while (reader.hasNext()) {
                    String word = reader.nextLine(); // 라인 단위로 단어 파일 읽기
                    v.add(word); // 읽은 단어를 벡터에 저장
                }
                reader.close();
                fileOn = true; // 파일이 성공적으로 읽혔음을 표시
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileOn = false; // 파일 읽기 실패 표시
            }
        }

        public boolean isFileRead() {
            return fileOn; // 파일이 성공적으로 읽혔는지 여부를 리턴
        }

        public boolean check(String word) {
            return v.contains(word); // 단어가 벡터 v에 있으면 true 리턴
        }
    }

    // 각 클라이언트를 전담하여 단어를 수신하고 "YES"나 "NO"를 전송하는 스레드
    class ServiceThread extends Thread {
        private Socket socket = null; // 클라이언트와의 통신을 위한 소켓
        private BufferedReader in = null; // 클라이언트로부터의 입력 스트림
        private BufferedWriter out = null; // 클라이언트로의 출력 스트림

        public ServiceThread(Socket socket) {
            this.socket = socket; // 클라이언트 소켓 저장
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 입력 스트림 초기화
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 출력 스트림 초기화

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String word = in.readLine(); // 클라이언트로부터 단어 수신
                    boolean res = spellChecker.check(word); // 스펠체크 결과 확인
                    if (res) {
                        out.write("YES\n");
                        System.out.println("요청단어 " + word + "=YES");
                    } else {
                        out.write("NO\n");
                        System.out.println("요청단어 " + word + "=NO");
                    }
                    out.flush(); // 출력 스트림 비우기 (클라이언트로 데이터 전송)
                } catch (IOException e) {
                    System.out.println("클라이언트 연결 종료");
                    try {
                        socket.close(); // 소켓 종료
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return; // 스레드 종료
                }
            }
        }
    }

    public static void main(String[] args) {
        SpellCheckerServer checker = new SpellCheckerServer(); // SpellCheckerServer 객체 생성
        checker.run(); // 서버 실행
    }
}
