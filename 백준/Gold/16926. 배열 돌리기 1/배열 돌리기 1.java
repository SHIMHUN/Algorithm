import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int R = Integer.parseInt(s[2]);

        origin = new int[N][M];

        // 원본 배열 입력
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                origin[i][j] = Integer.parseInt(line[j]);
            }
        }

        // R번 회전 수행
        for (int i = 0; i < R; i++) {
            rotate(N, M);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int[] arr : origin) {
            for (int ele : arr) {
                sb.append(ele).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void rotate(int N, int M) {
        int[][] rotated = new int[N][M];

        // 레이어별로 처리
        int layers = Math.min(N, M) / 2;
        for (int layer = 0; layer < layers; layer++) {
            // 현재 레이어의 테두리 원소들을 시계방향으로 이동
            int startX = layer, startY = layer;
            int endX = N - layer - 1, endY = M - layer - 1;

            // 아래 -> 오른쪽 -> 위 -> 왼쪽으로 이동
            // 아래 (startX부터 endX까지)
            for (int x = startX; x < endX; x++) {
                rotated[x + 1][startY] = origin[x][startY];
            }
            // 오른쪽 (startY부터 endY까지)
            for (int y = startY; y < endY; y++) {
                rotated[endX][y + 1] = origin[endX][y];
            }
            // 위 (endX부터 startX까지)
            for (int x = endX; x > startX; x--) {
                rotated[x - 1][endY] = origin[x][endY];
            }
            // 왼쪽 (endY부터 startY까지)
            for (int y = endY; y > startY; y--) {
                rotated[startX][y - 1] = origin[startX][y];
            }
        }

        // rotated 배열을 origin 배열로 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(rotated[i], 0, origin[i], 0, M);
        }
    }
}
