/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-1. FileReader로 텍스트 파일 읽기
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class FileReaderEx {       											// FileReaderEx 클래스 선언
	 public static void main(String[] args) {  								// 프로그램의 시작점인 main 메서드
		 FileReader in = null;     											// FileReader 객체 선언 및 초기화
		 try {
			 in = new FileReader("c:\\windows\\system.ini"); 		// 지정된 경로의 파일을 읽기 위해 FileReader 객체 생성
			 int c;                											// 파일에서 읽은 문자를 저장할 변수
			 while ((c = in.read()) != -1) { 								// 파일의 끝까지 한 문자씩 읽기
				 System.out.print((char)c);  								// 읽은 문자를 콘솔에 출력, 정수형을 문자형으로 변환
			 }
			 in.close();           											// 파일을 모두 읽은 후 FileReader 스트림을 닫음
		 }
		 catch (IOException e) {   											// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 System.out.println("입출력 오류"); 							  // 예외 발생 시 메시지 출력
		 }
	 }
 }
 