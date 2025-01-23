import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N과 K 입력
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // D 배열 입력
        int[] D = new int[N+1]; //0이 아닌 1부터 시작하는 인덱스를 맞춰줌
        for (int i = 0; i < N; i++) {
            D[i+1] = scanner.nextInt();
        }
        scanner.nextLine(); // 버퍼 비우기

        // S 배열 입력
        int[] S = new int[N+1];
        for (int i = 0; i < N; i++) {
            S[i+1] = scanner.nextInt();
        }

        // K번 셔플
        for (int i = 0; i < K; i++) { // K번 반복
            int[] result = new int[N+1]; // 작업을 위한 임시 배열

            for (int j = 1; j < N+1; j++) { // N개의 카드 섞기
                result[S[j]] = D[j];
            }

            D = result; // 임시 배열을 새로운 배열로 설정
        }

        // 결과 출력
        for (int  i=1; i<N+1; i++) {
            System.out.print(D[i] + " ");
        }
        scanner.close();
    }
}
