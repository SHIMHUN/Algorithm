import java.io.*;
import java.util.*;
public class Main {
    static int[][] board;

    static int N;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            int rotation = Integer.parseInt(line[1]);

            int r = rotation/45;
            board = new int[N][N];

            int[][] original = new int[N][N]; //변하지 않는 값을 채우기 위한 변수

            //초기값 세팅
            for (int i = 0; i < N; i++) {
                String[] split = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(split[j]);
                    board[i][j] = val;
                    original[i][j] = val;
                }
            }
            //함수 실행
            for (int i = 0; i < Math.abs(r); i++) {
                if(rotation>0) {
                    clockwise();
                }else {
                    counterclockwise();
                }
            }

            //정답
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] == 0) { //정답 배열이 0일때, 원본 배열에서 값을 복사하여 정답 배열에 넣어준다
                        board[i][j] = original[i][j];
                    }
                    sb.append(board[i][j]+" ");
                }
                sb.append("\n");
            }


        }
        System.out.println(sb.toString());
    }


    public static void clockwise() {
        int[][] dummy = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            dummy[i][N/2] = board[i][i];
            dummy[i][i] = board[N/2][i];
            dummy[N/2][i] = board[N-i-1][i];
            dummy[N-i-1][i] = board[N-i-1][N/2];
        }
        board = dummy;
    }
    public static void counterclockwise() {
        int[][] dummy = new int[N][N];
        for (int i = 0; i < board.length; i++) {
            dummy[i][N/2] = board[i][N-1-i];
            dummy[i][i] = board[i][N/2];
            dummy[N/2][i] = board[i][i];
            dummy[N-i-1][i] = board[N/2][i];
        }
        board = dummy;
    }

}