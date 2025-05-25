import java.util.Stack;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int len = dartResult.length();
        
        Stack<Integer> stack = new Stack<>();//스택 선언
        
        for(int i=0; i<len; i++	) {
        	String s = ""+dartResult.charAt(i);
        	
        	if(s.matches("^[0-9]")) { //0~9점 사이일때
        		String num = s;
        		if(i<len-1 && dartResult.charAt(i+1)=='0') {
        			num += dartResult.charAt(i+1);
        			i++;
        		}
        		stack.push(Integer.parseInt(num));
        	}
        	else if(s.matches("[D,T]")) {
        		if(!s.isEmpty()) {
        			int num = stack.pop();
        			if(s.equals("D")) {
        				num = (int) Math.pow(num, 2);
        			}else {
        				num = (int) Math.pow(num, 3);
        			}
        			stack.push(num);
        		}
        	}
        	else if(s.matches("[*]")) {
        		int time =2;
        		if(stack.size()==1) {
        			int num = stack.pop();
        			num *= 2;
        			stack.push(num);
        		}else {
        			int num1 = stack.pop();
        			int num2 = stack.pop();
        			num1 *= 2;
        			num2 *= 2;
        		
        			stack.push(num2);
        			stack.push(num1);
        		}
        	}
        	else if(s.matches("[#]")) {
        		if(!stack.isEmpty()) {
        			int num = stack.pop();
        			num *= -1;
        			stack.push(num);
        		}
        	}
        }
        
        while(!stack.isEmpty()) {
        	answer += stack.pop();
        }
        return answer;
    }
}