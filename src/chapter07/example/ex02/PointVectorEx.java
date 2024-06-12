/*
 * 일자 : 24.05.03 (9week)
 * 범위 : Chapter 7. 컬렉션과 제네릭
 * 예제 : 7-2. Point 클래스의 객체들만 저장하는 벡터 만들기
 */

 package chapter07.example.ex02;				// chapter7 패키지에 속하는 클래스임을 명시
 import java.util.Vector;		// 자바 유틸리티 패키지에서 Vector 클래스를 임포트
 
 class Point {
	 private int x, y;	// 점의 x, y 좌표를 저장하는 멤버 변수
 
	 // 생성자: x, y 좌표를 초기화
	 public Point(int x, int y) {
		 this.x = x;
		 this.y = y;
	 }
 
	 // toString 메서드 오버라이딩: 점의 좌표를 문자열로 반환
	 public String toString() {
		 return "(" + x + "," + y + ")";
	 }
 }
 
 public class PointVectorEx {
	 public static void main(String[] args) {
		 Vector<Point> v = new Vector<Point>();		// Point 객체를 요소로만 가지는 벡터 생성
 
		 // 3개의 Point 객체 삽입
		 v.add(new Point(2, 3));
		 v.add(new Point(-5, 20));
		 v.add(new Point(30, -8));
 
		 v.remove(1);		// 인덱스 1의 Point(-5, 20) 객체 삭제
 
		 // 벡터에 있는 Point 객체 모두 검색하여 출력
		 for(int i=0; i<v.size(); i++) {
			 Point p = v.get(i); 		// 벡터의 i번째 Point 객체 가져오기
			 System.out.println(p); 	// 객체 p 출력 (p.toString()을 호출하여 좌표 출력)
		 }
	 }
 }
 