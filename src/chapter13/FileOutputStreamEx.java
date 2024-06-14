/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-3. FileOutputStream으로 바이너리 파일 쓰기
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class FileOutputStreamEx { 														// FileOutputStreamEx 클래스 선언
	 public static void main(String[] args) {  											// 프로그램의 시작점인 main 메서드
		 byte b[] = {7, 51, 3, 4, -1, 24};     											// 바이트 배열을 선언하고 초기화
 
		 try {
			 FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out"); 	// 지정된 경로의 파일에 쓰기 위한 FileOutputStream 객체 생성
			 for (int i = 0; i < b.length; i++) 										// 배열 b의 길이만큼 반복
				 fout.write(b[i]);              										// 배열 b의 각 요소를 파일에 바이너리 데이터로 기록
			 fout.close();                      										// 출력 스트림을 닫음
		 } catch (IOException e) {              										// 입출력 작업 도중 발생할 수 있는 예외를 처리
			 e.printStackTrace();               										// 예외 발생 시 오류 메시지 출력
		 }
		 System.out.println("c:\\Temp\\test.out을 저장하였습니다."); 					   // 파일 저장 완료 메시지 출력
	 }
 }
 