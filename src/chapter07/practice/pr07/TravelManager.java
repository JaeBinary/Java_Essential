package chapter07.practice.pr07; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

// 위치를 나타내는 클래스
class Location {
    private int x, y; 												// 위치의 x와 y 좌표

    public Location(int x, int y) {
        this.x = x; this.y = y; 									// 생성자에서 좌표 초기화
    }

    // 다른 Location 객체와의 거리를 계산하는 메서드
    public double distance(Location b) {
        double d = (x - b.x)*(x - b.x) + (y - b.y)*(y - b.y); 		// 두 좌표 간의 거리의 제곱을 계산
        return Math.sqrt(d); 										// 제곱근을 반환하여 실제 거리 계산
    }
}

// 여행 관리 프로그램
public class TravelManager {
    public static void main(String[] args) {
        ArrayList<Location> travel = new ArrayList<Location>(); 	// Location 객체를 저장할 ArrayList 생성
        Scanner scanner = new Scanner(System.in); 					// 사용자 입력을 받기 위한 스캐너 객체 생성
        
        travel.add(new Location(0, 0)); 						// 시작 위치를 (0,0)으로 설정
        System.out.println("쥐가 이동한 위치(x,y)를 5개 입력하라.");
        
        // 5개의 위치를 입력받아 ArrayList에 추가
        for (int i = 0; i < 5; i++) {
            System.out.print(">> ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            travel.add(new Location(x, y));
        }
        
        travel.add(new Location(0, 0)); 						// 최종 위치를 (0,0)으로 설정
        
        double sum = 0.0; 											// 총 이동 거리를 저장할 변수
        
        // 각 위치 간의 거리를 계산하여 총 이동 거리를 구함
        for (int i = 0; i < travel.size() - 1; i++) {
            double d = travel.get(i).distance(travel.get(i + 1)); 	// 현재 위치와 다음 위치 간의 거리 계산
            sum += d; 												// 거리를 누적
        }
        
        System.out.println("총 이동 거리는 " + sum); 				  // 총 이동 거리 출력
        scanner.close(); 											// 스캐너 리소스를 닫음
    }
}
