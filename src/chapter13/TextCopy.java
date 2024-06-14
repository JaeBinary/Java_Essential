/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-6. 텍스트 파일 복사
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class TextCopy {           																// TextCopy 클래스 선언
	 public static void main(String[] args) {
		 File src = new File("c:\\windows\\system.ini"); 								// 원본 파일
		 File dest = new File("c:\\Temp\\system.txt");   								// 복사 파일
 
		 int c;                   																// 파일에서 읽은 문자를 저장할 변수
		 try {
			 FileReader fr = new FileReader(src); 												// 파일 입력 문자 스트림에 연결
			 FileWriter fw = new FileWriter(dest); 												// 파일 출력 문자 스트림에 연결
			 while ((c = fr.read()) != -1) {      												// 문자 하나 읽고, -1은 파일 끝(EOF)을 의미
				 fw.write((char) c);              												// 읽은 문자를 복사 파일에 씀
			 }
			 fr.close();                          												// 입력 스트림을 닫음
			 fw.close();                          												// 출력 스트림을 닫음
			 System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");    // 복사 완료 메시지 출력
		 } catch (IOException e) {                												// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 System.out.println("파일 복사 오류"); 											  // 예외 발생 시 메시지 출력
		 }
	 }
 }
 