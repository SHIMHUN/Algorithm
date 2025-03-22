import java.io.*;

public class Main {
    static int N;
    static int[] stairs;
    static int[] DP;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        DP = new int[N+1];

        for(int i=1; i<=N; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        //DP 배열 초기화
        DP[1] = stairs[1];

        if(N>=2){
            DP[2] = stairs[1] + stairs[2];
        }

        for(int i=3; i<=N; i++){
            DP[i] = Math.max(DP[i-2], DP[i-3] + stairs[i-1]) + stairs[i];
        }

        System.out.println(DP[N]);
    }
}