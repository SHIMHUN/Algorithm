import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result,-1); //int 배열 -1로 초기화
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            //현재 수보다 작은 수 발견하면 result에 업데이트
            while(!stack.isEmpty() && num > numbers[stack.peek()]){
                result[stack.pop()] = num; 
            }
            
            stack.push(i);
        }
        
        return result;
    }
}