import java.util.*;

public class Main {
    static long[] DP = new long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 1;
        DP[4] = 2;
        DP[5] = 2;

        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int N = sc.nextInt();

            for(int j=1; j<=N; j++){
                if(DP[j] == 0){
                    DP[j] = DP[j-1] + DP[j-5];
                }
            }
            sb.append(DP[N] + "\n");
        }

        System.out.println(sb);
    }
}