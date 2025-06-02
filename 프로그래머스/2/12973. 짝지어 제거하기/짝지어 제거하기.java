import java.util.*;

class Solution
{   
    static Stack<Character> stack = new Stack<>();
    
    public int solution(String s)
    {
        
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){ //스택 비어있으면 그냥 push
                stack.push(c);
            }else if(stack.peek().equals(c)){ //스택 맨 위의 값이 현재값과 같으면 pop
                stack.pop();
            }else{
                stack.push(c); //스택 맨 위의 값이 현재값과 다르면 push
            }
        }
            
        return stack.isEmpty() ? 1 : 0;
    }
}