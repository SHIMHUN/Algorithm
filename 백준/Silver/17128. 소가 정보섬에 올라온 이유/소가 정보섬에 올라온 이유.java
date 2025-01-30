import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] A, DP; // 소의 품질 점수와 DP 배열
    static int N;       // 소의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NnQ = br.readLine().split(" ");
        N = Integer.parseInt(NnQ[0]);
        int Q = Integer.parseInt(NnQ[1]);

        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] modifyA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // DP 배열 초기화 및 S값 계산
        DP = new int[N];
        int S = 0;

        for (int i = 0; i < N; i++) {
            DP[i] = calc(i); // 초기 DP 값 계산
            S += DP[i];                 // 초기 S 값 계산
        }

        // 쿼리 처리
        for (int i = 0; i < Q; i++) {
            S = update(modifyA[i]-1, S);      // S 값 갱신, 배열은 0부터 시작이지만 입력값은 1부터 시작이므로 -1
            bw.write(S + "\n");        // 결과 출력
        }

        bw.flush();
        bw.close();
    }

    /**
     * 특정 인덱스에서 시작하는 4개의 원소의 곱 계산
     */
    public static int calc(int i) {
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
        // A[idx] 값 반전 -> 해당 값이 calc에서 활용됨
        A[idx] *= -1;

        /*
        * 변경된 인덱스와 관련된 DP 값 업데이트
        * a4을 적용하는 경우라고 가정?
        * a4 a5 a6 a7
        * a3 a4 a5 a6
        * a2 a3 a4 a5
        * a1 a2 a3 a4
        * 총 4개의 계산 상황에 영향을 끼침 -> for문을 4번 돌려서 dp와 누적합을 업데이트 해줘야 한다
        * */
        for (int i = 0; i < 4; i++) {
            int affectedIdx = (idx - i + N) % N; // 변경 기준이 될 인덱스 계산
            currentSum -= DP[affectedIdx];      // 기존 값 제거
            DP[affectedIdx] = calc(affectedIdx); // 기준 인덱스에 해당하는 DP를 새로 계산하여 저장
            currentSum += DP[affectedIdx];      // 갱신된 값 추가
        }

        return currentSum;
    }
}
