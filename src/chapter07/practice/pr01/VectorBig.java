package chapter07.practice.pr01; 		// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class VectorBig {
    public static void main(String[] args) {
        Vector<Double> v = new Vector<Double>(); 		// Double 타입의 벡터를 생성
        Scanner scanner = new Scanner(System.in); 		// 사용자 입력을 받기 위한 스캐너 객체 생성
        
        // 사용자로부터 5개의 실수(double)를 입력받아 벡터에 추가
        for(int i = 0; i < 5; i++) {
            double d = scanner.nextDouble(); 			// 실수를 입력받아
            v.add(d); 									// 벡터에 추가
        }
        
        // 가장 큰 수를 찾기 위해 초기값으로 벡터의 첫 번째 요소를 할당
        double big = v.get(0);
        
        // 벡터를 순회하며 가장 큰 수를 찾는 로직
        for(int i = 0; i < v.size(); i++) {
            if(big < v.get(i)) 							// 현재 저장된 가장 큰 수보다 큰 값을 발견하면
                big = v.get(i); 						// 그 값을 가장 큰 수로 갱신
        }
        
        // 가장 큰 수를 출력
        System.out.println("가장 큰 수는 " + big);
        
        scanner.close(); 								// 스캐너 리소스를 닫아줌
    }
}
