import java.io.*;
import java.util.*;

public class Main {
    static int[] DP;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        DP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //누적합 채워넣기
        for(int i=1; i<=N; i++){
            DP[i] = Integer.parseInt(st.nextToken()) * i; //Bi
        }
        
        for(int i=1; i<=N; i++){
            sb.append(DP[i] - DP[i-1]).append(" ");
        }
        
        System.out.print(sb);
    }
}