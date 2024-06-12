/*
 * 일자 : 24.05.17 (10week)
 * 범위 : Chapter 8. 자바 GUI 스윙 기초
 * 예제 : 8-1. 300x300 크기의 스윙 프레임 만들기
 */

 package chapter08.example.ex01; 			// chapter8 패키지에 속하는 클래스임을 명시
 import javax.swing.*; 			// 자바 스윙 라이브러리의 모든 클래스를 임포트
 
 /* MyFrame 클래스는 JFrame 클래스를 상속받음 */
 public class MyFrame extends JFrame {
	 /* MyFrame 클래스의 생성자 정의 */
	 public MyFrame() {
		 setTitle("300x300 스윙 프레임 만들기"); // 프레임의 제목 설정
		 setSize(300, 300); 			// 프레임의 크기를 너비 300, 높이 300으로 설정
		 setVisible(true); 						// 프레임을 화면에 보이도록 설정
	 }
	 
	 /* main 메서드: 자바 애플리케이션의 시작점 */
	 public static void main(String[] args) {
		 MyFrame frame = new MyFrame(); // MyFrame 객체를 생성하여 프레임을 표시
	 }
 }
 