import java.io.*;
import java.util.*;

public class Main {
    static int[][] houseMap;
    static boolean[][] visited;
    static int sum, N;
    static List<Integer> houseCnt = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houseMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(Integer.parseInt(s[j]) == 1) houseMap[i][j] = 1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && houseMap[i][j] == 1){
                    sum=0; //단지 시작할때 sum 초기화
                    dfs(i,j);
                    houseCnt.add(sum);
                }
            }
        }

        Collections.sort(houseCnt);
        System.out.println(houseCnt.size()); //단지수 출력
        for(int cnt : houseCnt){
            System.out.println(cnt); //단지당 집 갯수 출력
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        sum++;

        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            // 경계 체크
            if(newX >= 0 && newX < N && newY >= 0 && newY < N){
                if(!visited[newX][newY] && houseMap[newX][newY] == 1){
                    dfs(newX, newY);
                }
            }
        }
    }
}