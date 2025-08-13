import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2]; //N+1일에서 상담을 하는 경우 고려

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N+1; i++) {
            if(max < dp[i]) max = dp[i];

            int next = i + T[i]; //다음 일자
            int cost = P[i];

            if(next <= N+1){ //다음 일자가 상담 가능한 날을 벗어나지 않도록
                /*
                * 상담을 안하는 경우 -> dp[next]
                * 상담을 하는 경우 -> max+cost(현재까지의 최대 누적액 + 현재 상담 진행시 금액)
                * */
                dp[next] = Math.max(dp[next], max + cost);
            }
        }

        // 마지막 날까지 모든 경우의 수 계산 했을 때 최대 금액
        System.out.println(dp[N+1]);
    }
}