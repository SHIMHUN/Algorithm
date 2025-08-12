import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int maxFoodSize = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    maxFoodSize = Math.max(dfs(i, j), maxFoodSize);
//                    maxFoodSize = Math.max(bfs(i, j), maxFoodSize);

                }
            }
        }

        System.out.println(maxFoodSize);
    }

    static int dfs(int x, int y){
        visited[x][y] = true;
        int size = 1;

        for(int i=0; i<=3; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(rangeCheck(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 1){
                size+=dfs(newX, newY);
            }
        }

        return size;
    }

    static int bfs(int x, int y){
        int size = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<=3; i++){
                int newX = node.x+dx[i];
                int newY = node.y+dy[i];

                if(rangeCheck(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 1){
                    size++;
                    visited[newX][newY] = true;
                    q.offer(new Node(newX, newY));
                }
            }
        }

        return size;
    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean rangeCheck(int x, int y){
        return x>=1 && y>=1 && x<=N && y<=M;
    }
}