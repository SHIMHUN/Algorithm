import java.util.*;

public class Main {
//    static Long[] DP = new Long[1001];
    static Integer[] DP = new Integer[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

//        DP[1] = 1L;
//        DP[2] = 3L;
        DP[1] = 1;
        DP[2] = 3;

        for(int i = 3; i<=N; i++){
            DP[i] = (DP[i-1] + 2 * DP[i-2]) % 10007;
//            DP[i] = (DP[i-1] + 2 * DP[i-2]);
        }

        System.out.println(DP[N]);
//        System.out.println(DP[N] % 10007);
    }

}