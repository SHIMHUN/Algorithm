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
            s = Integer.toString(i);

            int sum = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).sum();

            if(i+sum == N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}