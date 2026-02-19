import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> belt = new ArrayDeque<>();
        Deque<Integer> subBelt = new ArrayDeque<>();
        int cnt = 0;
        
        for(int i=order.length; i>=1; i--){
            belt.push(i);
        }
        
        for(int box : order){
            
            while(!belt.isEmpty() && belt.peek() < box) {
                subBelt.push(belt.pop());
            }
            
            if(!belt.isEmpty() && belt.peek() == box){
                belt.pop();
            }else if(!subBelt.isEmpty() && subBelt.peek() == box){
                subBelt.pop();
            }else{
                break;
            }
            
            cnt++;
        }
        
        return cnt;
        
    }
}