package chapter07.practice.pr03; 		// 패키지 선언
import java.util.HashMap; 				// HashMap 클래스를 포함
import java.util.Scanner; 				// Scanner 클래스를 포함

public class CoffeeHashMap {

    public static void main(String[] args) {
        // 커피 이름과 가격을 저장할 HashMap 생성
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        // 커피 메뉴와 가격을 HashMap에 추가
        map.put("에스프레소", 2000);
        map.put("아메리카노", 2500);
        map.put("카푸치노", 3000);
        map.put("카페라떼", 2500);
        
        // 메뉴 안내 메시지 출력
        System.out.println("에스프레소, 아메리카노, 카푸치노, 카페라떼 있습니다.");
        
        // 사용자 입력을 받기 위한 스캐너 객체 생성
        Scanner scanner = new Scanner(System.in);
        
        // 무한 반복하여 주문을 받음
        while(true) {
            System.out.print("주문 >> ");
            String coffee = scanner.next(); 									// 사용자가 주문한 커피 이름을 입력받음
            if(coffee.equals("그만")) 									 // 사용자가 '그만'을 입력하면 반복 종료
                break;
                
            Integer price = map.get(coffee); 									// 주문한 커피의 가격을 HashMap에서 가져옴
            
            if(price == null) 													// 주문한 커피가 HashMap에 없으면
                System.out.println(coffee + " 메뉴 없습니다."); 				  // 해당 메뉴 없음 메시지 출력
            else
                System.out.println(coffee + "는 " + price + "입니다."); 		 // 가격 출력
        }
        
        scanner.close(); 														// 스캐너 리소스를 닫음
    }
}
