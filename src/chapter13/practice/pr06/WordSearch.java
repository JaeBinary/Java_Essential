package chapter13.practice.pr06;  // chapter13.practice.pr06 패키지에 속하는 클래스임을 명시
import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
import java.util.*;               // 자바 유틸리티 관련 클래스들을 포함하는 패키지를 임포트

public class WordSearch {         // WordSearch 클래스 선언
    public static void main(String[] args) {
        // words.txt 파일 읽기
        Vector<String> v = new Vector<String>(); // 단어들을 저장할 벡터 생성
        try {
            Scanner fscanner = new Scanner(new FileReader("words.txt")); // 파일로부터 읽기 위한 Scanner 객체 생성
            while (fscanner.hasNext()) // 파일에 읽을 단어가 있는 동안 반복
                v.add(fscanner.next()); // 단어를 벡터에 추가
            fscanner.close(); // 파일 스캐너 닫기
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다."); // 입출력 예외 발생 시 메시지 출력
        }

        // 단어 검색
        Scanner scanner = new Scanner(System.in); // 키보드 입력을 위한 Scanner 객체 생성
        while (true) {
            boolean found = false; // 단어 발견 여부를 나타내는 변수
            System.out.print("단어>>");
            String search = scanner.next(); // 키보드로부터 검색할 단어 입력받기
            if (search.equals("exit")) { // 'exit' 입력 시 종료
                System.out.println("종료합니다...");
                break; // 검색 종료
            }

            for (int i = 0; i < v.size(); i++) { // 벡터의 각 단어를 순회
                String vs = v.get(i); // 벡터 내의 단어
                if (vs.length() < search.length()) // 벡터의 단어가 검색 단어보다 짧은 경우
                    continue;
                // 벡터 단어의 앞부분을 검색 단어 크기만큼 잘라내기
                String a = vs.substring(0, search.length());
                if (search.equals(a)) { // 검색 단어와 잘라낸 부분 비교
                    System.out.println(vs); // 일치하는 단어 출력
                    found = true; // 단어를 발견했음을 표시
                }
            }
            if (!found) // 단어를 발견하지 못한 경우
                System.out.println("발견할 수 없음");
        }

        scanner.close(); // 키보드 스캐너 닫기
    }
}
