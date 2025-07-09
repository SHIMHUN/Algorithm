//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringTokenizer st = new StringTokenizer(s, "-");

        int sum = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            StringTokenizer temp = new StringTokenizer(st.nextToken(), "+");
            int addition = 0;

            while(temp.hasMoreTokens()){
                addition += Integer.parseInt(temp.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = addition;
            }else{
                sum -= addition;
            }
        }

        System.out.println(sum);
    }
}