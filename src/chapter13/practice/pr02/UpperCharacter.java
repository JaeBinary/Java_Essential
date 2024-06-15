package chapter13.practice.pr02;  // chapter13.practice.pr02 패키지에 속하는 클래스임을 명시
import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트

public class UpperCharacter {     // UpperCharacter 클래스 선언

    public static void main(String[] args) {
        try {
            FileReader fin = new FileReader("c:\\windows\\system.ini"); // 파일 입력 문자 스트림 생성
            int c;                // 파일에서 읽은 문자를 저장할 변수
            while ((c = fin.read()) != -1) { // 파일 끝까지 한 문자씩 읽기
                char a = (char) c;           // 읽은 문자를 char로 변환
                if (Character.isLowerCase(a)) // 문자가 소문자인지 확인
                    a = Character.toUpperCase(a); // 소문자를 대문자로 변환
                System.out.print(a); // 변환된 문자를 화면에 출력
            }
            fin.close();           // 입력 스트림을 닫음
        } catch (IOException e) {  // 입출력 작업 도중 발생할 수 있는 예외를 처리
            System.out.println("파일 읽기 오류"); // 예외 발생 시 메시지 출력
        }
    }
}
