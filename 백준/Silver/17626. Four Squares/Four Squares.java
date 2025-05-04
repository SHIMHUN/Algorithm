import java.util.*;

public class Main {

    static int[] DP = new int[50001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=1; i<=N; i++){
            DP[i] = Integer.MAX_VALUE;
        }

        DP[0] = 0;
        DP[1] = 1;

        for(int i=2; i<=N; i++){ //모든 DP 배열을 채우기 위함
            for(int j=1; j*j<=i; j++){ //1^2, 2^2, 3^2 ... 의 형태인 제곱수를 DP 계산에 사용하였으므로 기존에 재활용하는 DP+1을 해줌
                DP[i] = Math.min(DP[i], DP[i-j*j]+1); //가능한 모든 경우를 검사하면서 매 루프마다 최소의 갯수 업데이트
            }
        }

        System.out.println(DP[N]);
    }
}