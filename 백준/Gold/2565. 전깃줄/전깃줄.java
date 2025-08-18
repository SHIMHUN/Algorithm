import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        int[][] wire = new int[N][2];
        int[] dp = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0; i<N; i++){
            dp[i] = 1;

            for(int j=0;j<i;j++){
                /*
                * i번째 이전의 전봇대를 탐색하면서
                * A->B 연결 가능하려면 j번째의 B전봇대는 i번째의 B전봇대보다 작아야 함
                 * */
                if(wire[i][1] > wire[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        // 전체 개수 - 설치 가능한 전깃줄 = 최소 철거 개수
        System.out.println(N - max);
    }
}