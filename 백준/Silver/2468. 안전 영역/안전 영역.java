import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int safeRegionCnt = 1; //아무 지역도 물에 안잠기는 경우 고려(하나의 영역이 됨)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int heightInfo = Integer.parseInt(st.nextToken()); //높이 정보
                if(heightInfo > max) max = heightInfo; //최댓값 갱신
                graph[i][j] = heightInfo;
            }
        }

        for(int z=1; z<=max; z++){
            visited = new boolean[N+1][N+1];
            int tmpRegionCnt = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && graph[i][j] > z){
                        tmpRegionCnt++;
                        dfs(i, j, z);
                    }
                }
            }
            
            if(tmpRegionCnt > safeRegionCnt) safeRegionCnt = tmpRegionCnt;
        }

        System.out.println(safeRegionCnt);
    }

    static void dfs(int x, int y, int z){
        visited[x][y] = true;

        for(int i=0; i<=3; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(rangeCheck(newX, newY) && !visited[newX][newY] && graph[newX][newY] > z){
                dfs(newX, newY, z);
            }
        }
    }

    static boolean rangeCheck(int x, int y){
        return x>=0 && y>=0 && x<N && y<N;
    }
}