package chapter07.practice.prBonus01; 	// 패키지 선언
import java.util.*; 					// 필요한 유틸리티 클래스를 포함

public class HV {
    // HashMap을 Vector로 변환하는 메서드
    public static Vector<String> hashToVector(HashMap<String, String> h) {
        Vector<String> v = new Vector<String>(); 						// 벡터 생성
        Set<String> s = h.keySet(); 									// 해시맵 h로부터 키의 Set 컬렉션 s 얻기
        Iterator<String> it = s.iterator();
        
        // 키를 반복하면서 벡터에 값을 추가
        while(it.hasNext()) {
            String key = it.next();
            v.add(h.get(key)); 											// '값'을 벡터에 삽입
        }
        
        return v; 														// 변환된 벡터를 반환
    }
    
    public static void main(String [] args) {
        HashMap<String, String> h = new HashMap<String, String>(); 		// 해시맵 h 생성
        h.put("범죄", "112");
        h.put("화재", "119");
        h.put("전화번호", "114");
        
        // hashToVector() 호출하여 해시맵을 벡터로 변환
        Vector<String> v = hashToVector(h);
        
        // 벡터의 모든 요소를 출력
        for(int n = 0; n < v.size(); n++) {
            System.out.print(v.get(n) + " ");
        }
    }
}
