import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
        int sum = 0;

        while(k-- > 0){
//            int num = sc.nextInt();
            int num = Integer.parseInt(br.readLine());
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