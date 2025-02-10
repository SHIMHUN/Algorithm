import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};
    static int minNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        arr = new int[N][M];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 최소 회전 그룹의 수
        minNum = Math.min(N, M) / 2;

        // 각 그룹별 회전 수행
        for (int t = 0; t < minNum; t++) {
            // 그룹별 한 바퀴 길이 계산
            int perimeter = 2 * ((N - 2 * t) + (M - 2 * t) - 2);

            // 실제 회전 횟수 최적화
            int rotationCount = R % perimeter;

            // 그룹 회전
            rotateGroup(t, rotationCount, N, M);
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 특정 그룹 회전
    static void rotateGroup(int t, int rotationCount, int N, int M) {
        int perimeter = 2 * ((N - 2 * t) + (M - 2 * t) - 2);

        // 그룹 값을 배열에 저장
        int[] group = new int[perimeter];
        int idx = 0;

        int x = t;
        int y = t;

        // 그룹의 값 추출
        int direction = 0;
        while (idx < perimeter) {
            group[idx++] = arr[x][y];

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 범위를 벗어나면 방향 전환
            if (nx < t || nx >= N - t || ny < t || ny >= M - t) {
                direction++;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        // 그룹 회전 (R만큼 이동)
        int[] rotatedGroup = new int[perimeter];
        for (int i = 0; i < perimeter; i++) {
            rotatedGroup[(i + perimeter - rotationCount) % perimeter] = group[i];
        }

        // 회전된 값을 다시 배열에 반영
        x = t;
        y = t;
        direction = 0;
        idx = 0;
        while (idx < perimeter) {
            arr[x][y] = rotatedGroup[idx++];

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 범위를 벗어나면 방향 전환
            if (nx < t || nx >= N - t || ny < t || ny >= M - t) {
                direction++;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }
    }
}
