/*
 * 일자 : 24.06.14 (14week)
 * 범위 : Chapter 13. 입출력 스트림과 파일 입출력
 * 예제 : 13-8. 고속 복사를 위한 블록 단위 바이너리 파일 복사
 */

 package chapter13;                // chapter13 패키지에 속하는 클래스임을 명시
 import java.io.*;                 // 자바 입출력 관련 클래스들을 포함하는 패키지를 임포트
 
 public class BlockBinaryCopy {     															// BlockBinaryCopy 클래스 선언
	 public static void main(String[] args) {
		 File src = new File("c:\\Temp\\img.jpg"); 									// 원본 파일
		 File dest = new File("c:\\Temp\\back.jpg"); 									// 복사 파일
		 try {
			 FileInputStream fi = new FileInputStream(src);  									// 파일 입력 바이트 스트림 생성
			 FileOutputStream fo = new FileOutputStream(dest); 									// 파일 출력 바이트 스트림 생성
			 byte[] buf = new byte[1024 * 10]; 													// 10KB 버퍼 생성
			 while (true) {
				 int n = fi.read(buf); 															// 버퍼 크기만큼 읽기. n은 실제 읽은 바이트 수
				 if (n == -1) 																	// 파일 끝에 도달하면 -1 반환
					 break;
				 fo.write(buf, 0, n); 														// 읽은 바이트 수만큼 버퍼의 내용을 복사 파일에 쓰기
			 }
			 fi.close(); 																		// 입력 스트림 닫기
			 fo.close(); 																		// 출력 스트림 닫기
			 System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");    // 복사 완료 메시지 출력
		 } catch (IOException e) { 																// 입출력 작업 도중 예외 처리
			 System.out.println("파일 복사 오류"); 											  // 오류 메시지 출력
		 }
	 }
 }
 