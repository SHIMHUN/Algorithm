import java.io.*;
import java.util.*;

public class Main {

    //북동남서
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y=  y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];
        int[][] visited = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Point point = new Point(x, y);
        int dir = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalCnt = 0;

        while(true){
            if(room[point.x][point.y] == 0){
                room[point.x][point.y] = 2; //청소 안되어있으면 청소
                totalCnt++;
            }

            boolean flag = false;

            for(int i=0; i<4; i++){ //주변 4칸 탐색
                dir = (dir+3)%4; // 왼쪽으로 회전

                int newX = point.x + dx[dir];
                int newY = point.y + dy[dir];

                // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 회전 후 한칸 전진
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && room[newX][newY] == 0) {
                    // 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                    point.x = newX;
                    point.y = newY;
                    flag = true;
                    break;
                }
                
                //청소 할 공간이 없으면 1번으로 돌아감
            }

            if(!flag){ //4방향 모두 청소할 곳이 없다면
                // 뒤쪽 칸이 벽인지 확인
                int back_d = (dir + 2) % 4; // 현재 방향의 뒤쪽 방향
                int newX = point.x + dx[back_d];
                int newY = point.y + dy[back_d];

                // 뒤쪽이 벽이 아니라면 후진
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && room[newX][newY] != 1) {
                    point.x = newX;
                    point.y = newY;
                }
                // 뒤쪽 칸이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                else {
                    break;
                }
            }

        }

        System.out.println(totalCnt);
    }


}