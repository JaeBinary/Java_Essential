package chapter13.practice.pr04;  // chapter13.practice.pr04 패키지에 속하는 클래스임을 명시
import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
import java.util.NoSuchElementException; // NoSuchElementException 클래스를 임포트
import java.util.Scanner;         // Scanner 클래스를 임포트

public class LineNumber {         // LineNumber 클래스 선언
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 키보드로부터 읽기 위한 Scanner 객체 생성
        String src;
        System.out.print("텍스트 파일 이름을 입력하세요>>");
        src = scanner.nextLine(); // 키보드로부터 파일명을 입력받음
        try {
            Scanner fileScanner = new Scanner(new FileReader(src)); // 파일로부터 읽기 위한 Scanner 객체 생성
            String line; // 파일에서 읽은 한 줄을 저장할 변수
            int lineNumber = 1; // 행 번호를 저장할 변수
            while (fileScanner.hasNext()) { // 파일에 읽을 것이 있는 동안 반복
                line = fileScanner.nextLine(); // 파일에서 한 줄 읽기
                System.out.printf("%4d: %s%n", lineNumber++, line); // 행 번호와 함께 줄을 출력
            }
            fileScanner.close(); // 파일 스캐너 닫기
        } catch (FileNotFoundException e) { // 파일을 찾지 못했을 때 예외 처리
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (NoSuchElementException e) { // 파일 끝에 도달했을 때 예외 처리
            System.out.println("파일의 끝에 도달하여 읽을 내용이 없습니다.");
        } finally {
            scanner.close(); // 키보드 스캐너 닫기
        }
    }
}
