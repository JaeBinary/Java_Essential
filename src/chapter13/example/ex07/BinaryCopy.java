/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-7. 바이너리 파일 복사
 */

 package chapter13.example.ex07;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class BinaryCopy {         																// BinaryCopy 클래스 선언
	 public static void main(String[] args) {
		 File src = new File("c:\\Temp\\img.jpg"); 									// 원본 파일
		 File dest = new File("c:\\Temp\\back.jpg"); 									// 복사 파일
 
		 int c;                   																// 파일에서 읽은 바이트를 저장할 변수
		 try {
			 FileInputStream fi = new FileInputStream(src);  									// 파일 입력 바이트 스트림 생성
			 FileOutputStream fo = new FileOutputStream(dest); 									// 파일 출력 바이트 스트림 생성
			 while ((c = fi.read()) != -1) { 													// 파일 끝까지 한 바이트씩 읽기
				 fo.write((byte) c);         													// 읽은 바이트를 복사 파일에 씀
			 }
			 fi.close();                     													// 입력 스트림을 닫음
			 fo.close();                     													// 출력 스트림을 닫음
			 System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");    // 복사 완료 메시지 출력
		 } catch (IOException e) {           													// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 System.out.println("파일 복사 오류"); 											  // 예외 발생 시 메시지 출력
		 }
	 }
 }
 