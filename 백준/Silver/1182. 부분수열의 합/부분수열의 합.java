import java.io.*;
import java.util.*;

public class Main {
    static int[] numbers;
    static int N, S, totalCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(S == 0) totalCnt--;

        System.out.println(totalCnt);
    }

    static void dfs(int cnt, int sum){
        if(cnt == N){
            if(sum == S) totalCnt++;
            return;
        }

        dfs(cnt+1, sum);
        dfs(cnt+1, sum+numbers[cnt]);
    }
}