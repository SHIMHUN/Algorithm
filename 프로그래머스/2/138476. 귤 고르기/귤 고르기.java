import java.util.*;

class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // map에 저장
        for(int fruit : tangerine){
            // map.putIfAbsent(fruit, 0);
            // map.put(fruit, map.get(fruit)+1);
            
            // fruit이 key로 저장되어있지 않으면 0, 저장되어있으면 기존 값에 +1
            map.put(fruit, map.getOrDefault(fruit,0) + 1);
            
        }
        
        // value 기준으로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        // k개를 만족할 때까지 누적
        for(Map.Entry<Integer, Integer> entry : entryList){
            int value = entry.getValue();
            
            k-=value;
            answer++;
            if(k <= 0){
                break;
            }
            
            // if(!(value > k) && k-value >= 0){
            //     k-=value;
            //     answer++;
            //     if(k == 0){
            //         break;
            //     }
            // }
            
        }
        // System.out.println(map.toString());
        
        return answer;
    }
}