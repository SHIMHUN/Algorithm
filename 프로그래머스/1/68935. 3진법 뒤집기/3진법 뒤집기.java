import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        while(n!=0){
            dq.addLast(n%3);
            n/=3;            
            
            // if(n==1 || n==2){
            //     dq.addLast(n);
            // }
        }
        
        int idx=0;
        while(!dq.isEmpty()){
            answer += dq.pollLast() * Math.pow(3, idx);
            idx++;
        }
        return answer;
    }
}