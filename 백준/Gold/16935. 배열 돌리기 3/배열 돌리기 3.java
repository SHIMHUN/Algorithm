import java.util.*;
import java.io.*;


public class Main {
    static int[][] origin;
    static int N, M, R;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        R = Integer.parseInt(line[2]);

        origin = new int[N][M];

        for(int i=0; i<N; i++){
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
            for(int j=0; j<M; j++){
                origin[i][j] = nums[j];
            }
        }

        int[] type = Arrays.stream(br.readLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
        for(int i=0; i<R; i++){
            switch(type[i]){
                case 1:
                    upDown();
                    break;
                case 2:
                    leftRight();
                    break;
                case 3:
                    turnRight();
                    break;
                case 4:
                    turnLeft();
                    break;
                case 5:
                    groupTurnRight();
                    break;
                case 6:
                    groupTurnLeft();
            }
        }

        for(int[] arr : origin){
            for(int ele : arr){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    static void upDown(){
        for(int i=0; i<N/2; i++){
            for(int j=0; j<M; j++){
                int tmp = origin[i][j];
                origin[i][j] = origin[N-i-1][j];
                origin[N-i-1][j] = tmp;

            }
        }
    }

    static void leftRight(){
        for(int i=0; i<M/2; i++){
            for(int j=0; j<N; j++){
                int tmp = origin[j][i];
                origin[j][i] = origin[j][M-i-1];
                origin[j][M-i-1] = tmp;

            }
        }
    }

    static void turnRight(){
        int[][] convert = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                convert[i][j] = origin[N - j - 1][i];
        }
        int temp = N;
        N = M;
        M = temp;
        origin = convert;
    }

    static void turnLeft(){
        int[][] convert = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                convert[i][j] = origin[j][M - i - 1];
        }
        int temp = N;
        N = M;
        M = temp;
        origin = convert;
    }

    static void groupTurnRight(){
        int[][] convert = new int[N][M];

        for (int i = 0; i < N / 2; i++) // 1번
             for (int j = 0; j < M / 2; j++)
                 convert[i][j] = origin[i + N / 2][j];

        for (int i = 0; i < N / 2; i++) // 2번
              for (int j = M / 2; j < M; j++)
                  convert[i][j] = origin[i][j - M / 2];

        for (int i = N / 2; i < N; i++) // 3번
             for (int j = M / 2; j < M; j++)
                 convert[i][j] = origin[i - N / 2][j];

        for (int i = N / 2; i < N; i++) // 4번
             for (int j = 0; j < M / 2; j++)
                 convert[i][j] = origin[i][j + M / 2];

        origin = convert;
    }

    static void groupTurnLeft(){
        int[][] convert = new int[N][M];

        for (int i = 0; i < N / 2; i++) // 1번
            for (int j = 0; j < M / 2; j++)
                convert[i][j] = origin[i][j + M / 2];

        for (int i = 0; i < N / 2; i++) // 2번
            for (int j = M / 2; j < M; j++)
                convert[i][j] = origin[i + N / 2][j];

        for (int i = N / 2; i < N; i++) // 3번
            for (int j = M / 2; j < M; j++)
                convert[i][j] = origin[i][j - M / 2];

        for (int i = N / 2; i < N; i++) // 4번
            for (int j = 0; j < M / 2; j++)
                convert[i][j] = origin[i - N / 2][j];
        origin = convert;
    }
}