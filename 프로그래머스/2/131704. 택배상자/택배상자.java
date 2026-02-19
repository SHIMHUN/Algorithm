import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> belt = new Stack<>();
        Stack<Integer> subBelt = new Stack<>();
        int cnt = 0;
        
        for(int i=order.length; i>=1; i--){
            belt.push(i);
        }
        
        for(int i=0; i<order.length; i++){
            int box = order[i];
            
            while(!belt.isEmpty() && belt.peek() < box) subBelt.push(belt.pop());
            
            if(!belt.isEmpty() && belt.peek() == box){
                belt.pop();
                cnt++;
            }else if(!subBelt.isEmpty() && subBelt.peek() == box){
                subBelt.pop();
                cnt++;
            }else{
                break;
            }
        }
        
        return cnt;
        
    }
}