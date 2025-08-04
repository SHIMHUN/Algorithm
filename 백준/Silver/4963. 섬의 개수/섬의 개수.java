import java.io.*;
import java.util.*;

public class Main {
    //상, 하, 좌, 우, 대각
    static int[] dx ={0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy ={-1, 1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            if(s.equals("0 0")) break;

            StringTokenizer st = new StringTokenizer(s);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int cnt=0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        cnt++;
                        dfs(i, j, map, visited, w, h);
                    }
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y, int[][] map, boolean[][] visited, int w, int h){
        visited[x][y] = true; //방문 처리

        for(int i=0; i<8; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(newX < h && newX >= 0 && newY < w && newY >= 0 && !visited[newX][newY] && map[newX][newY] == 1){
                dfs(newX, newY, map, visited, w, h);
            }
        }
    }
}