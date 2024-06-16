package chapter14.practice.pr04;
import java.io.*;
import java.net.*;
import java.util.*;

public class WordChainServer {
    private SpellChecker spellChecker;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private ServerSocket listener = null;
    private Socket socket = null;

    public WordChainServer() { }

    public void run() {
        System.out.println("끝말잇기 서버입니다.");
        spellChecker = new SpellChecker("hangulwords.txt");
        spellChecker.isFileRead();
        System.out.println("hangulwords.txt 읽기 완료");

        try {
            listener = new ServerSocket(9998); // 서버 소켓 생성
            socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
            System.out.println("클라이언트 연결됨");

            // 클라이언트와 통신을 위한 입출력 스트림 설정
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String startWord = spellChecker.selectWord(); // 시작 단어 선택
            System.out.println("시작 단어는 " + startWord + "입니다.");

            // 클라이언트에게 시작 단어 전송
            out.write(startWord + "\n");
            out.flush();
            System.out.println("서버>> " + startWord); // 화면에 시작 단어 출력

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // 클라이언트로부터 단어 수신
                String clientWord = in.readLine();

                // 클라이언트가 보낸 단어 화면에 출력
                System.out.println("클라이언트>> " + clientWord);

                boolean res = spellChecker.check(clientWord); // 스펠링 체크
                if (res) { // 클라이언트가 성공했을 경우
                    out.write("YES\n");
                    out.flush();
                } else { // 클라이언트가 실패했을 경우
                    out.write("NO\n");
                    out.flush();
                    System.out.println("서버가 이겼습니다.");
                    break; // 게임 종료
                }

                // 서버가 단어를 입력하고, 스펠링 체크
                System.out.print("서버>> ");
                String serverWord = scanner.next();
                res = spellChecker.check(serverWord);

                if (res) { // 서버가 성공했을 경우
                    out.write(serverWord + "\n");
                    out.flush();
                    continue;
                } else { // 서버가 실패했을 경우
                    out.write("win\n"); // 클라이언트가 이겼음을 전송
                    out.flush();
                    System.out.println("서버가 졌습니다.");
                    break;
                }
            }
            scanner.close();

        } catch (IOException e) {
            System.out.println("클라이언트 연결 종료");
        }

        try {
            if (listener != null)
                listener.close();
            if (socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 끝말잇기 게임을 위한 스펠링 체크 클래스
    class SpellChecker {
        private String startWord;
        private String currentWord;
        private Vector<String> v = new Vector<>(); // 단어를 저장할 벡터
        private boolean fileOn = false;

        public SpellChecker(String fileName) {
            try {
                Scanner reader = new Scanner(new FileReader(fileName)); // 파일을 읽기 위한 Scanner
                while (reader.hasNext()) {
                    String word = reader.nextLine(); // 단어 파일을 한 줄씩 읽어 벡터에 저장
                    v.add(word);
                }
                reader.close();
                fileOn = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                fileOn = false;
            }
        }

        public boolean isFileRead() {
            return fileOn;
        }

        // 단어가 벡터에 포함되어 있는지 확인하는 메소드
        public boolean check(String word) {
            if (v.contains(word)) {
                char lastChar = currentWord.charAt(currentWord.length() - 1);
                char firstChar = word.charAt(0);
                if (lastChar == firstChar) { // 마지막 글자와 첫 글자가 같을 경우
                    currentWord = word; // 현재 단어를 업데이트
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        // 랜덤하게 단어 선택
        public String selectWord() {
            int index = (int) (Math.random() * v.size());
            startWord = v.get(index);
            currentWord = startWord;
            return startWord;
        }
    }

    public static void main(String[] args) {
        WordChainServer server = new WordChainServer();
        server.run(); // 서버 실행
    }
}
