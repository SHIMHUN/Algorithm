import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] A;
    static int N;
    static int S; // 전체 합을 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NnQ = br.readLine().split(" ");
        N = Integer.parseInt(NnQ[0]);
        int Q = Integer.parseInt(NnQ[1]);

        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] modify_A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 초기 합계 계산
        S = calcInitialSum();

        for (int i = 0; i < Q; i++) {
            int idx = modify_A[i] - 1; // 1-based index to 0-based
            updateSum(idx); // 값 변경에 따른 합계 업데이트
            bw.write(S + "\n"); // 결과 출력
        }

        bw.flush();
        bw.close();
    }

    // 초기 합계 계산 (O(N))
    public static int calcInitialSum() {
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            int mid_sum = 1;
            for (int j = 0; j < 4; j++) {
                mid_sum *= A[(i + j) % N];
            }
            totalSum += mid_sum;
        }
        return totalSum;
    }

    // 합계 업데이트 (O(1))
    public static void updateSum(int idx) {
        // 변경 전의 영향을 제거
        for (int j = 0; j < 4; j++) {
            int startIdx = (idx - j + N) % N; // 순환 인덱스 처리
            int mid_sum = 1;
            for (int k = 0; k < 4; k++) {
                mid_sum *= A[(startIdx + k) % N];
            }
            S -= mid_sum; // 기존 값을 제거
        }

        // 값 변경
        A[idx] *= -1;

        // 변경 후의 영향을 추가
        for (int j = 0; j < 4; j++) {
            int startIdx = (idx - j + N) % N; // 순환 인덱스 처리
            int mid_sum = 1;
            for (int k = 0; k < 4; k++) {
                mid_sum *= A[(startIdx + k) % N];
            }
            S += mid_sum; // 새로운 값을 추가
        }
    }
}
