import java.util.*;

public class Main {
    static int[][] field; // 배추 밭
    static boolean[][] visited; // 방문 여부
    static int M, N, K; // M: 가로, N: 세로, K: 배추가 심어진 위치 갯수

    // 상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y) {
        visited[x][y] = true; // 방문 표시

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) { // 배추 밭 범위 안에 있는지 확인
                if (field[nx][ny] == 1 && !visited[nx][ny]) { // 현재 위치가 배추가 심어진 곳이지만 아직 방문 x
                    dfs(nx, ny); // 그 주변을 계속 탐색
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); // 먼저 시작 위치를 큐에 담는다
        visited[x][y] = true; // 해당 위치 방문 처리

        while (!q.isEmpty()) {
            int[] now = q.poll(); // 큐에 있는 좌표를 하나 꺼내서 현재 위치로 설정
            int new_x = now[0];
            int new_y = now[1];

            for (int i = 0; i < 4; i++) { // 상하좌우 4방향 확인
                int nx = new_x + dx[i];
                int ny = new_y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (field[nx][ny] == 1 && !visited[nx][ny]) { // 현재 위치가 배추가 심어진 곳이지만 아직 방문 x
                        visited[nx][ny] = true; // 방문처리하고 좌표를 큐에 넣음
                        q.offer(new int[]{nx, ny}); // 큐에 넣는 이유? 해당 좌표를 방문하고 이 좌표를 기준으로 탐색하기 위해서
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스 수

        while (T-- > 0) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            K = sc.nextInt(); // 배추 위치 수

            field = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) { // 배추 심어진 곳 표시
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[x][y] = 1;
            }

            int count = 0;

            // 배추 밭을 돌면서 방문 x인 배추 심어진 위치에서 주변 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
//                        dfs(i, j);
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}