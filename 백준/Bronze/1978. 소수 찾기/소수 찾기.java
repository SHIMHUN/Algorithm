import java.util.*;
import java.io.*;

public class Main {
    static int sum=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();

        for(int i=0; i<N; i++){
            find(nums[i]);
        }
        System.out.println(sum);
    }

    public static void find(int num){
        if(num==1) return;

//        if(num==3){
//            sum++;
//            return;
//        }

        for(int i=2; i<=num/2; i++){
            if(num%i == 0){ // 약수가 있다면
                return;
            }
        }
//        System.out.println("test");
        sum++;
        return;
    }
}