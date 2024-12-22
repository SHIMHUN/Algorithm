import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        
        for(int ele:arr){
            if(stack.peek() != ele){
                stack.push(ele);
            }
        }
        
        
        int[] answer = {};
        answer = new int[stack.size()];
        
        int i=answer.length;
        while(!stack.isEmpty()){
            answer[--i] = stack.pop();
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}