import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //이름별로 참여자 map에 저장
        for(String runner : participant){
            // map.putIfAbsent(runner, 0);
            // map.put(runner, map.get(runner)+1);
            
            //key가 존재한다면 value를 가져와서 +1, 존재하지 않는다면 1
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }
        
        //완주자의 이름이 참여자에 있는지 확인
        for(String finish : completion){
            map.get(finish);
            map.put(finish, map.get(finish)-1);
        }
        
        //value가 0이 아니면 아직 완주하지 못한 동명이인이 있음 
        for(String s : map.keySet()){
            if(map.get(s) >= 1){
                answer+=s;
            }
        }
        
        return answer;
    }
}