import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; //정의: 현재 인덱스를 포함하는 최대 연속합
        int max = dp[0] = A[0]; //최초 최대값은 첫번째 값임 -> Integer.MIN_VALUE로 설정하면 안된다

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]); //현재값과 현재값+지금까지의 누적합 비교
            max = Math.max(max, dp[i]); //max값 업데이트
        }
        System.out.println(max);
    }
}