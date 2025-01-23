import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //태그 구분
        //<를 마주쳤다면 >만날떄까지 continue

        /*
        * 1. if < 마주쳤다면 > 만날때까지 그대로 출력 문자열에 추가
        * 2. else 문자를 마주쳤다면, < 마주칠 때까지 문자열을 담아서 < 마주치면 문자열을 공백 기준으로 split
        * 3. 각 단어당 뒤에서부터 루프를 돌려서 출력 문자열에 추가
        * */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String result = "";
        Stack<Character> stack = new Stack<>();

        int i = 0;

        while(i < s.length()){
            char c = s.charAt(i);

            if(c == '<'){
                while(i<s.length() && s.charAt(i) != '>'){
                    result += s.charAt(i);
                    i++;
                }
                result += '>';
                i++;
            }else if(c != ' '){
                while(i<s.length() && s.charAt(i) != ' ' && s.charAt(i) != '<'){

                    stack.push(s.charAt(i));
                    i++;
                }
                while(!stack.isEmpty()){
                    result += stack.pop();
                }
            }else{
                result += ' ';
                i++;
            }
        }
        System.out.println(result);
    }
}