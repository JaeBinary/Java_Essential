package chapter13.practice.pr03;  // chapter13.practice.pr03 패키지에 속하는 클래스임을 명시
import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트

public class FileSize {           // FileSize 클래스 선언

    public static void main(String[] args) {
        File f = new File("c:\\"); // 루트 디렉토리 "c:\\"를 나타내는 File 객체 생성
        File[] files = f.listFiles(); // 디렉토리에 포함된 파일과 디렉토리의 리스트 얻기
        long big = 0; // 가장 큰 파일의 크기를 저장할 변수
        File file = null; // 가장 큰 파일을 저장할 변수

        for (int i = 0; i < files.length; i++) { // 파일 리스트를 순회하는 루프
            File a = files[i]; 
            if (!a.isFile()) // 파일이 아니면 건너뛰기
                continue;
            long size = a.length(); // 파일의 크기 얻기
            if (big < size) { // 현재 저장된 최대 크기보다 크다면
                big = size; // 최대 크기를 갱신
                file = a; // 해당 파일을 가장 큰 파일로 설정
            }
        }

        if (file == null) // 파일이 없는 경우
            System.out.println("파일은 없습니다");
        else // 가장 큰 파일과 그 크기를 출력
            System.out.println("가장 큰 파일은 " + file.getPath() + " " + big + "바이트");
    }

}
