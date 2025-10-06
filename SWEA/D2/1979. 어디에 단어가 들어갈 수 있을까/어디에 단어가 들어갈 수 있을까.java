import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            // 가로 검사
            for (int i = 0; i < N; i++) {
                int consecutive = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 1) consecutive++;
                    else {
                        if (consecutive == K) count++;
                        consecutive = 0;
                    }
                }
                if (consecutive == K) count++;
            }

            // 세로 검사
            for (int j = 0; j < N; j++) {
                int consecutive = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] == 1) consecutive++;
                    else {
                        if (consecutive == K) count++;
                        consecutive = 0;
                    }
                }
                if (consecutive == K) count++;
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}