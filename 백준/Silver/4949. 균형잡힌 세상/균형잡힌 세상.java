import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){ // '.' 일때 종료
            String s = br.readLine();
            if(s.equals(".")){
                break;
            }

            Stack<Character> stack = new Stack<>();

            boolean isValid = true;

            for(char c : s.toCharArray()){
                if(c == '(' || c == '['){
                    stack.push(c);
                }else if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }else if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        isValid = false;
                        break;
                    }
                    stack.pop();
                }


            }

            if(!isValid || !stack.isEmpty()){
                sb.append("no"+"\n");
            }else{
                sb.append("yes"+"\n");
            }

        }

        System.out.println(sb);
    }
}