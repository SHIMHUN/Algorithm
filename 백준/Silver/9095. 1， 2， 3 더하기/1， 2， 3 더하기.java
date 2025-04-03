import java.io.*;

public class Main {
    static int N;
    static Integer[] DP = new Integer[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            for(int j=4; j<=num; j++){
                DP[j] = DP[j-1] + DP[j-2] + DP[j-3];
            }
            sb.append(DP[num] + "\n");
        }
        System.out.println(sb);
    }

}