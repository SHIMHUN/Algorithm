import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score); //사과들을 오름차순 정렬
        
        int ptr = score.length-m; //각 상자당 가장 낮은 점수를 가리킬 포인터 변수
        
        
        while(ptr >= 0){ //다음 포인터 위치가 범위를 안벗어날 때까지 계산
            answer+=score[ptr]*m;
            ptr-=m;
        }
        
        return answer;
    }
}