import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        int[][] origin = new int[N][M];
        int[][] rotated = new int[N][M];

        // 방향 벡터: 아래 -> 오른쪽 -> 위 -> 왼쪽
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // 배열 입력
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(line[j]);
            }
        }

        // R번 회전
        for (int r = 0; r < R; r++) {
            rotated = new int[N][M]; // 새로운 결과 배열 초기화
            for (int layer = 0; layer < Math.min(N, M) / 2; layer++) { // 각 레이어별 처리
                int x = layer, y = layer; // 시작 좌표
                int direction = 0; // 초기 방향
                int prev = origin[x][y]; // 현재 값을 저장

                do {
                    int next_x = x + dx[direction];
                    int next_y = y + dy[direction];

                    // 방향 전환 조건
                    if (next_x < layer || next_x >= N - layer || next_y < layer || next_y >= M - layer) {
                        direction = (direction + 1) % 4; // 방향 변경
                        next_x = x + dx[direction];
                        next_y = y + dy[direction];
                    }

                    // 값 이동
                    int temp = origin[next_x][next_y];
                    rotated[next_x][next_y] = prev;
                    prev = temp;

                    x = next_x;
                    y = next_y;

                } while (x != layer || y != layer); // 시작점으로 돌아올 때까지 반복
            }

            // `rotated`를 `origin`으로 복사
            for (int i = 0; i < N; i++) {
                System.arraycopy(rotated[i], 0, origin[i], 0, M);
            }
        }

        // 출력
        for (int[] row : rotated) {
            for (int ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
