/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-4. FileInputStream으로 바이너리 파일 읽기
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class FileInputStreamEx {  														// FileInputStreamEx 클래스 선언
	 public static void main(String[] args) {  											// 프로그램의 시작점인 main 메서드
		 byte b[] = new byte[6];   														// 크기가 6인 비어 있는 byte 배열 선언
		 try {

			 // "c:\\Temp\\test.out" 파일을 읽어 배열 b에 저장
			 FileInputStream fin = new FileInputStream("c:\\Temp\\test.out"); 		// 지정된 경로의 파일을 읽기 위한 FileInputStream 객체 생성
			 int n = 0, c;         														// 읽은 바이트 수를 저장할 변수 n과 파일로부터 읽은 데이터를 저장할 변수 c
			 while ((c = fin.read()) != -1) { 											// 파일 끝까지 한 바이트씩 읽기
				 b[n] = (byte) c;  														// 읽은 바이트를 배열에 저장
				 n++;
			 }
			 
			 // 배열 b의 바이트 값을 모두 화면에 출력
			 System.out.println("c:\\Temp\\test.out에서 읽은 배열을 출력합니다.");
			 for (int i = 0; i < b.length; i++) 										// 배열 b 출력
				 System.out.print(b[i] + " ");  										// 각 바이트 값을 공백으로 구분하여 출력
			 System.out.println();  													// 줄바꿈
			 
			 fin.close();           													// 입력 스트림을 닫음
		 } catch (IOException e) {  													// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 e.printStackTrace();   													// 예외 발생 시 오류 메시지 출력
		 }
	 }
 }
 