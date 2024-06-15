package chapter13.practice.pr05;  // chapter13.practice.pr05 패키지에 속하는 클래스임을 명시
import java.io.File;               // 자바 파일 입출력 관련 클래스를 임포트

public class FileDelete {          // FileDelete 클래스 선언

    public static void main(String[] args) {
        File dir = new File("c:\\Temp\\"); // "c:\\Temp\\" 디렉토리를 나타내는 File 객체 생성
        File[] files = dir.listFiles(); // 디렉토리에 포함된 파일과 디렉토리의 리스트 얻기

        for (int i = 0; i < files.length; i++) { // 파일 리스트를 순회하는 루프
            String name = files[i].getName(); // 파일의 이름을 얻기
            int index = name.lastIndexOf('.'); // 파일명에서 마지막 '.'의 인덱스를 찾기
            if (index == -1) // '.'가 없는 경우
                continue;
            String ext = name.substring(index); // 확장자를 추출 (예: ".txt")
            if (ext.equals(".txt")) { // 확장자가 ".txt"인 경우
                System.out.println(files[i].getPath() + " 삭제"); // 파일 경로를 출력
                files[i].delete(); // 파일 삭제
            }
        }
    }
}
