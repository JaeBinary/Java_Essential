package chapter07.practice.pr06; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class CustomerManager {

    // HashMap의 내용을 출력하는 메서드
    static void printMap(HashMap<String, Integer> map) {
        Set<String> keys = map.keySet(); 									// HashMap의 키들을 가져옴
        Iterator<String> it = keys.iterator();
        while(it.hasNext()) {
            String name = it.next(); 										// 키(고객 이름)를 가져옴
            int point = map.get(name); 										// 해당 키의 값(포인트)를 가져옴
            System.out.print("(" + name + "," + point + ")"); 				// 이름과 포인트를 출력
        }
        System.out.println(); // 줄바꿈
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(); 		// 고객 이름과 포인트를 저장할 HashMap 생성
        System.out.println("** 포인트 관리 프로그램입니다 **");
        Scanner scanner = new Scanner(System.in); 							// 사용자 입력을 받기 위한 스캐너 객체 생성

        while(true) {
            System.out.print("이름과 포인트 입력>>");
            String name = scanner.next(); 									// 이름 입력 받기
            if(name.equals("exit")) 								// 'exit' 입력 시 프로그램 종료
                break;
            int point = scanner.nextInt(); 									// 포인트 입력 받기
            Integer n = map.get(name); 										// 해당 이름의 현재 포인트를 가져옴
            if(n != null) {
                point += n; 												// 이미 존재하는 이름이라면 포인트를 누적
            }
            map.put(name, point); 											// 이름과 포인트를 HashMap에 추가 또는 갱신
            printMap(map); 													// 현재 HashMap의 내용을 출력
        }
        
        System.out.println("프로그램을 종료합니다...");
        scanner.close(); 													// 스캐너 리소스를 닫음
    }
}
