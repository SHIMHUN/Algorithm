import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //dp[i][j]: 길이가 i이고, j로 끝나는 계단 수의 갯수
        long[][] dp = new long[N+1][10];

        for(int j=1; j<=9; j++){
            dp[1][j] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1] % 1000000000;
                }else if(j==9){
                    dp[i][j] = dp[i-1][8]% 1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])% 1000000000;
                }
            }
        }

        long total = 0;
        for(int i=0; i<=9; i++){
            total+=dp[N][i];
        }
        System.out.println(total% 1000000000);
    }
}