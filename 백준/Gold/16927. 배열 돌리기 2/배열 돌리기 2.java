import java.io.*;

public class Main {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        int layers = Math.min(N, M) / 2; 

        for (int t = 0; t < layers; t++) {
            //각 레이어마다 회전해야할 수를 구하고 회전 함수 실행
            int count = 2 * ((N - 2 * t) + (M - 2 * t) - 2); 
            int rotations = R % count; 

            for (int r = 0; r < rotations; r++) {
                rotateLayer(t, N, M); 
            }
        }

       
        for (int[] row : arr) {
            for (int num : row) {
                sb.append(num).append(" ");
//                System.out.print(num + " ");
            }
            sb.append("\n");
//            System.out.println();
        }
        
        System.out.println(sb.toString());
    }

    static void rotateLayer(int t, int N, int M) {
        int x = t;
        int y = t;
        int temp = arr[x][y]; // 시작 위치 값 저장

        int direction = 0;

        while (direction < 4) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 범위 체크
            if (nx < t || ny < t || nx >= N - t || ny >= M - t) {
                direction++;
                continue;
            }

            arr[x][y] = arr[nx][ny]; 
            x = nx;
            y = ny;
        }

        arr[t + 1][t] = temp; // 마지막 위치에 저장한 값 대입
    }
}