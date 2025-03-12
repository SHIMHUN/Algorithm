import java.util.*;
import java.io.*;

public class Main {
    static String[][] board;
    static int N, M;
    static int final_cnt = 64; // 최악의 경우 64칸 모두 다시 칠해야 하므로 초기값 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = String.valueOf(line.charAt(j)); // 한 글자씩 저장
            }
        }

        // 8x8 체스판을 만들 수 있는 모든 시작점 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int chessBoard = findChessBoard(i, j);
                final_cnt = Math.min(final_cnt, chessBoard);
            }
        }
        System.out.println(final_cnt);
    }

    static int findChessBoard(int x, int y) {
        int white_cnt = 0; // W 시작
        int black_cnt = 0; // B 시작

        for (int i = 0; i < 8; i++) {  // 8x8 체스판 탐색
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) { // 짝수 칸
                    if (!board[x + i][y + j].equals("W")) white_cnt++;
                    if (!board[x + i][y + j].equals("B")) black_cnt++;
                } else { // 홀수 칸
                    if (!board[x + i][y + j].equals("B")) white_cnt++;
                    if (!board[x + i][y + j].equals("W")) black_cnt++;
                }
            }
        }
        return Math.min(white_cnt, black_cnt);
    }
}
