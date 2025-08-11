import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx={0, 0, -1, 1};
    static int[] dy={-1, 1, 0, 0};
    static int M, N, K;
    static int regionCnt = 0;
    static List<Integer> regionSize = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][N];
        visited = new boolean[M][N];

        for(int z=0; z<K; z++){
            st = new StringTokenizer(br.readLine());
            int leftDownX = Integer.parseInt(st.nextToken());
            int leftDownY = Integer.parseInt(st.nextToken());
            int rightUpX = Integer.parseInt(st.nextToken());
            int rightUpY = Integer.parseInt(st.nextToken());

            for(int i = leftDownY; i < rightUpY; i++){
                for(int j = leftDownX; j < rightUpX; j++){
                    graph[i][j] = 1;
                }
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && graph[i][j] == 0){
                    regionCnt++;
//                    regionSize.add(dfs(i, j));
                    regionSize.add(bfs(i, j));

                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(regionCnt).append("\n");

        Collections.sort(regionSize);
        for(int size : regionSize){
            sb.append(size).append(" ");
        }

        System.out.println(sb);
    }
//
//    static int dfs(int x, int y){
//        int size = 1;
//
//        for(int i=0; i<=3; i++){
//            int newX = x+dx[i];
//            int newY = y+dy[i];
//
//            if(rangeCheck(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 0){
//                size+=dfs(newX, newY);
//            }
//        }
//
//        return size;
//    }

    static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));
        visited[x][y] = true;

        int size = 1;

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int i=0; i<=3; i++){
                int newX = curr.x+dx[i];
                int newY = curr.y+dy[i];

                if(rangeCheck(newX, newY) && !visited[newX][newY] && graph[newX][newY] == 0){
                    visited[newX][newY] = true;
                    q.offer(new Node(newX, newY));
                    size++;
                }
            }
        }

        return size;
    }

    static boolean rangeCheck(int x, int y){
        return x>=0 && y>=0 && x<M && y<N;
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}