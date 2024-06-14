/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-2. FileWriter를 이용하여 텍스트 파일 쓰기
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class FileWriterEx {       										// FileWriterEx 클래스 선언
	 public static void main(String[] args) {  							// 프로그램의 시작점인 main 메서드
		 InputStreamReader in = new InputStreamReader(System.in); 		// 표준 입력 스트림(System.in)으로부터 문자를 읽기 위해 InputStreamReader 객체 생성
 
		 FileWriter fout = null;   										// FileWriter 객체 선언 및 초기화
		 int c;                    										// 입력받은 문자를 저장할 변수
		 try {
			 fout = new FileWriter("c:\\Temp\\test.txt"); 		// 지정된 경로의 파일에 쓰기 위한 FileWriter 객체 생성
			 while ((c = in.read()) != -1) { 							// 키보드로부터 문자를 읽어들임, -1은 입력의 끝(EOF)을 의미
				 fout.write(c);              							// 읽은 문자를 파일에 씀
			 }
			 in.close();                     							// 입력 스트림을 닫음
			 fout.close();                   							// 출력 스트림을 닫음
		 } catch (IOException e) {           							// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 System.out.println("입출력 오류"); 						  // 예외 발생 시 메시지 출력
		 }
	 }
 }
 