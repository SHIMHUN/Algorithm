import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        
        int execTime = 0;
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            
            //cache hit
            if(cache.contains(city)){
                cache.remove(city);
                cache.offer(city);
                execTime+=1;
            }else{
                if(cache.size() == cacheSize){ //캐시 꽉참(LRU로 교체)
                    cache.poll();
                }
                cache.offer(city);
                
                execTime+=5;
            }
        }
        
        
        return execTime;
    }
}