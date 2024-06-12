package chapter07.practice.pr05; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class HashMapNation {
    public static void main(String[] args) {
        // 나라 이름과 인구를 저장할 HashMap 생성
        HashMap<String, Integer> nations = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in); 		// 사용자 입력을 받기 위한 스캐너 객체 생성
        
        // 5개의 나라 이름과 인구를 입력받아 HashMap에 추가
        System.out.println("나라 이름과 인구를 5개 입력하세요.(예: Korea 5000)");
        for(int i = 0; i < 5; i++) {
            System.out.print("나라 이름, 인구 >> ");        
            String nation = scanner.next(); 			// 나라 이름 입력 받기
            int population = scanner.nextInt(); 		// 인구 입력 받기
            nations.put(nation, population); 			// 나라 이름과 인구를 HashMap에 추가
        }
        
        int bigPopu = 0; 								// 가장 많은 인구를 저장할 변수
        String bigNation = ""; 							// 가장 많은 인구의 나라를 저장할 변수
        
        // HashMap의 keySet을 이용하여 각 나라의 인구를 순회
        Set<String> names = nations.keySet();
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String name = it.next(); 					// 현재 나라 이름 가져오기
            int n = nations.get(name); 					// 현재 나라의 인구 가져오기
            if(bigPopu < n) { 							// 현재 저장된 가장 많은 인구보다 크면
                bigPopu = n; 							// 가장 많은 인구 갱신
                bigNation = name; 						// 해당 나라 이름 갱신
            }
        }
        
        // 가장 인구가 많은 나라와 그 인구를 출력
        System.out.println("제일 인구가 많은 나라는 (" + bigNation + ", " + bigPopu + ")");
        
        scanner.close(); 								// 스캐너 리소스를 닫음
    }
}
