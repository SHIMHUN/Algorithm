import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] A, DP; // 소의 품질 점수와 DP 배열
    static int N;       // 소의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] NnQ = br.readLine().split(" ");
        N = Integer.parseInt(NnQ[0]); // 소의 수
        int Q = Integer.parseInt(NnQ[1]); // 쿼리 수

        // 품질 점수 배열 입력
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 수정할 소의 번호 입력
        int[] modifyA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // DP 배열 초기화 및 S값 계산
        DP = new int[N];
        int S = 0;

        for (int i = 0; i < N; i++) {
            DP[i] = calculateProduct(i); // 초기 DP 값 계산
            S += DP[i];                 // 초기 S 값 계산
        }

        // 쿼리 처리
        for (int i = 0; i < Q; i++) {
            int index = modifyA[i] - 1; // 입력은 1-based, 배열은 0-based
            S = update(index, S);      // S 값 갱신
            bw.write(S + "\n");        // 결과 출력
        }

        bw.flush();
        bw.close();
    }

    /**
     * 특정 인덱스에서 시작하는 4개의 원소의 곱 계산
     */
    public static int calculateProduct(int i) {
        int product = 1;
        for (int j = 0; j < 4; j++) {
            product *= A[(i + j) % N];
        }
        return product;
    }

    /**
     * 특정 인덱스가 변경될 때 S와 DP 배열 갱신
     */
    public static int update(int idx, int currentSum) {
        // A[idx] 값 반전
        A[idx] *= -1;

        // 변경된 인덱스와 관련된 DP 값 업데이트
        for (int i = 0; i < 4; i++) {
            int affectedIdx = (idx - i + N) % N; // 순환하는 인덱스 계산
            currentSum -= DP[affectedIdx];      // 기존 값 제거
            DP[affectedIdx] = calculateProduct(affectedIdx); // DP를 새로 계산하여 저장
            currentSum += DP[affectedIdx];      // 갱신된 값 추가
        }

        return currentSum;
    }
}
