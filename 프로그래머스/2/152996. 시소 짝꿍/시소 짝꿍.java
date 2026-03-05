import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        
        Map<Double, Long> map = new HashMap<>();
        long answer = 0;
        
        for(int w : weights){
            
            double[] ratios = {1.0, 2.0/3, 1.0/2, 3.0/4};
            
            for(double r : ratios){
                double target = w * r;
                
                if(map.containsKey(target)){
                    answer += map.get(target);
                }
            }
            
            map.put((double)w, map.getOrDefault((double)w, 0L) + 1);
        }
        
        return answer;
    }
}