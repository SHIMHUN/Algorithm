import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N]; //i번째 원소를 무조건 포함하는 가장 긴 감소하는 부분 수열 길이 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dp[i] = 1; //초기 세팅에서는 자기 자신만 저장 -> 길이 1

            for(int j=0; j<i; j++){
                if(A[j] > A[i] && dp[j]+1 > dp[i]){ //감소하는 관계이면서 비교하는 dp의 길이가 더 길다면 갱신
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = Integer.MIN_VALUE; //dp중에서 가장 긴 부분 수열 구하기
        for(int num: dp){
            if(num > max) max = num;
        }

        System.out.println(max);
    }
}