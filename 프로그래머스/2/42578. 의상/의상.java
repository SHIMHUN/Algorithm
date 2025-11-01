import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        for(String[] s : clothes){
            String type = s[1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }
        
        int result = 1;
        for(int count : map.values()){
            result *= (count+1);
        }
        
        return result-1;
    }
}