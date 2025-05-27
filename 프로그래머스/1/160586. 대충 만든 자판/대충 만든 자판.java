import java.util.*;

class Solution {
    //keymap 전체를 순회하면서, 각 문자의 최소 입력 횟수를 저장
    static Map<Character, Integer> map = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        //targets 순회하며 문자마다 합산, 못찾는 문자는 -1 처리
        
        //1. 문자별 최소 입력 횟수 기록
        for(String key:keymap){
            for(int i=0; i<key.length(); i++){
                char c = key.charAt(i);
                int pressCount = i+1; //자판은 0부터 시작하지만, 실제 누르는 횟수는 1부터
                //동일한 문자가 여러 자판줄에 있을 수 있음, 그 중 가장 적게 눌러도 되는 경우 저장
                map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), pressCount)); 
            }
        }
        
        //2. 각 targer 단어마다 계산
        for(int i=0; i<targets.length; i++){
            int sum=0;
            
            for(char c: targets[i].toCharArray()){
                if(map.containsKey(c)){
                    sum+=map.get(c);
                }else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        
        
        return answer;
    }
}