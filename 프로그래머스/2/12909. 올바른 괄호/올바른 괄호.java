import java.util.*;

class Solution {
    static Stack<Character> stack = new Stack<>();
    
    boolean solution(String s) {
        boolean answer = true;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            // '('면 스택에 추가, ')'면 스택이 비어있는지 확인 후 pop
            if(ch == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return (stack.isEmpty())? true:false;
    }
}