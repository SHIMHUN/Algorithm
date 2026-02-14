import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s=s.replaceAll("[{}]","");
        String[] arr = s.split(",");
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            map.put(Integer.parseInt(arr[i]), map.getOrDefault(Integer.parseInt(arr[i]), 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        
        
        
        return list.stream()
                   .mapToInt(Integer::intValue)
                   .toArray();
    }
}