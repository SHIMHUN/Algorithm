import java.util.*;

class Solution {
    static List<Integer> al = new ArrayList<>();
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
    
        
        for(int i=0; i<score.length; i++){
            //1. ArrayList에 값 추가
            al.add(score[i]);
            
            //2. 정렬
            Collections.sort(al);
                
            if(al.size() > k){
                al.remove(0);
            }

            //4. k번째 값 가져와서 결과 배열에 저장
            answer[i] = al.get(0);
        }
        
        return answer;
    }
}