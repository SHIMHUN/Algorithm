import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수열 입력을 저장할 배열
        int[] A = new int[N];
        // A[i]를 마지막으로 하는 가장 긴 증가하는 부분 수열의 길이
        int[] dp_increase = new int[N];
        // A[i]를 시작으로 하는 가장 긴 감소하는 부분 수열의 길이
        int[] dp_decrease = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 1. LIS 계산 (왼쪽 -> 오른쪽 순방향)
        for (int i = 0; i < N; i++) {
            dp_increase[i] = 1; // 자기 자신만으로도 길이는 1
            for (int j = 0; j < i; j++) {
                // j번째 원소가 i번째 원소보다 작고, 새로운 길이가 더 길다면 갱신
                if (A[j] < A[i]) {
                    dp_increase[i] = Math.max(dp_increase[i], dp_increase[j]+1);
                }
            }
        }

        // 2. LDS 계산 (오른쪽 -> 왼쪽 역방향)
        for (int i = N - 1; i >= 0; i--) {
            dp_decrease[i] = 1; // 자기 자신만으로도 길이는 1
            for (int j = N - 1; j > i; j--) {
                // j번째 원소가 i번째 원소보다 작고, 새로운 길이가 더 길다면 갱신
                // (거꾸로 가는 LIS와 원리가 같음)
                if (A[j] < A[i]) {
                    dp_decrease[i] = Math.max(dp_decrease[i], dp_decrease[j]+1);
                }
            }
        }

        // 3. 결과 합산 및 최댓값 찾기
        int max_length = 0;
        for (int i = 0; i < N; i++) {
            // 증가하는 부분 길이 + 감소하는 부분 길이 - 1 (peak 중복 제거)
            int bitonic_length = dp_increase[i] + dp_decrease[i] - 1;
            max_length = Math.max(bitonic_length, max_length);
        }

        System.out.println(max_length);
    }
}