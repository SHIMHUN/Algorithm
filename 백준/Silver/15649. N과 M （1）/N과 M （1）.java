import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N+1];

        dfs(0);
        System.out.print(sb);

    }

    static void dfs(int depth){
        if(depth == M){ // 수열 길이 만족시 현재까지 완성된 수열 출력
            for(int i=0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                arr[depth] = i; //현재 수열에 추가
                dfs(depth+1);
                isUsed[i] = false;
            }
        }
    }
}