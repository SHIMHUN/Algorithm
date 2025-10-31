import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int sum = 0;

        while(k-- > 0){
            int num = sc.nextInt();
            if(num==0){
                sum-=stack.pop();
            }else{
                stack.push(num);
                sum+=num;
            }
        }

        System.out.print(sum);
    }
}