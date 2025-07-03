import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> product = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        
        // 상품 구성
        for(int i=0; i<want.length; i++){
            product.put(want[i],number[i]);
        }
        
        // 초기 10일 간의 윈도우 설정
        for(int i=0; i<10; i++){
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        int start = 0;
        int end = 9;
        int result = 0;
        
        
        while(end < discount.length){
            // 원하는 수량을 살 수 있는지 검사
            boolean check = true;
            for (String key : product.keySet()) {
                if (map.getOrDefault(key, 0) != product.get(key)) { //product에는 있지만 map에는 없는 경우 고려(할인 품목이 아님)
                    check = false;
                    break;
                }
            }
            if(check){
                result++;
            }
            
            // 4. 슬라이딩 윈도우 이동: map 업데이트
            map.put(discount[start], map.get(discount[start]) - 1);
            if (map.get(discount[start]) == 0) {
                map.remove(discount[start]);
            }

            end++;
            start++;

            // 인덱스 체크 (discount.length 초과 방지)
            if (end < discount.length) {
                map.put(discount[end], map.getOrDefault(discount[end], 0) + 1);
            }
        }
        
        return result;
    }
}