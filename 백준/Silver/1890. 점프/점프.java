import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[N-1][N-1] = 1;

        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(i==N-1 && j==N-1) continue;

                int jump=board[i][j];
                int nextRight = j+jump; //x값 이동(j변경)
                int nextDown = i+jump; //y값 이동(i변경)

                if(nextRight<N) dp[i][j] += dp[i][nextRight];
                if(nextDown<N) dp[i][j] += dp[nextDown][j];
            }
        }
        System.out.println(dp[0][0]);


    }
}