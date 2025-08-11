import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int pictureCnt= 0;
    static int pictureSize=0;
    static List<Integer> pictures = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    pictureCnt++;
                    pictureSize = 0;
                    dfs(i, j);
                    pictures.add(pictureSize);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        if(pictures.size() >= 1){
            Collections.sort(pictures, Collections.reverseOrder());
            sb.append(pictureCnt).append("\n").append(pictures.get(0));
        }else{ // 그림이 하나도 없는 경우
            sb.append(pictureCnt).append("\n").append(0);
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;
        pictureSize++;

        for(int i=0; i<=3; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(checkRange(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 1){
                dfs(newX, newY);
            }
        }
    }

    static boolean checkRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}