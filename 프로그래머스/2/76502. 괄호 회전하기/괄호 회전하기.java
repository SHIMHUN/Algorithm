import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        
        int cnt = 0;
        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            
            innerLoop:
            for(int j=0; j<n; j++){
                int index = (j+i) % n;
                char c = s.charAt(index); // 선택된 문자
                
                if(c == '[' || c == '(' || c == '{'){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){ // 닫힌 괄호가 들어갈 차례에 열린 괄호가 스택에 x -> 실패
                        check = false;
                        break innerLoop;
                    }else{
                        char top = stack.pop();
                        if((c == ']' && top != '[') || (c == ')' && top != '(') || (c == '}' && top != '{')){ // 짝이 맞지 않는 경우 -> 실패
                            check = false;
                            break innerLoop;
                        }  
                    }
                }
            }
            if(!stack.isEmpty()){
                check = false;
            }
            if(check == true) {
                cnt++;
            }
        }
        return cnt;
    }
}