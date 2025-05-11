import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        // 인물에 대한 점수 map에 사전 추가
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int score = 0;
            
            for(String s : photo[i]){
                if(map.containsKey(s)){
                    score+=map.get(s);
                }
            }
            
            answer[i] = score;
        }
        
        return answer;
    }
}