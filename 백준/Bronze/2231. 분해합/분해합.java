import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=1; i<N; i++){
//            s = Integer.toString(i);
            int number = i;
            int sum = 0;

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기
                number /= 10;
            }
//            int sum = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();

            if(i+sum == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}