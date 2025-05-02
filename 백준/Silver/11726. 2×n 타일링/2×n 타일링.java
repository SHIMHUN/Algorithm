import java.util.*;
public class Main {

    static Integer[] DP = new Integer[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DP[1] = 1;
        DP[2] = 2;
        for(int i=3; i<=N; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 10007;
        }

        System.out.println(DP[N]%10007);
    }

    static int tile(int N){
        if(DP[N] == null){
            DP[N] = tile(N-1) + tile(N-2);
        }

        return DP[N];
    }
}