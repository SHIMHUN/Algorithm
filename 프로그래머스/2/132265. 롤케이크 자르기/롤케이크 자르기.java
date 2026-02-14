import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int sameCount = 0;
        Set<Integer> chulsoo = new HashSet<>();
        Map<Integer, Integer> dongsang = new HashMap<>();
        
        for(int i=0; i<topping.length; i++){
            dongsang.put(topping[i], dongsang.getOrDefault(topping[i], 0)+1);    
        }
        
        for(int i=0; i<topping.length; i++){
            chulsoo.add(topping[i]);
            
            
            dongsang.put(topping[i], dongsang.get(topping[i])-1);
            if(dongsang.get(topping[i]) == 0){
                dongsang.remove(topping[i]);
            }
            
            if(chulsoo.size() == dongsang.size()) sameCount++;
        }
        
        return sameCount;
    }
}