import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int count=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //무방향 그래프
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i=1; i<N+1; i++){
            if(!visited[i]){ //방문하지않았으면 dfs 시작
//                dfs(i);
                bfs(i);
                count++; //dfs 끝나면 연결요소 개수 +1
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x){
        visited[x] = true; //현재 노드 방문 처리

        for(int i=1; i<=N; i++){
            if(graph[x][i] == 1 && !visited[i]){ //값이 존재하며 아직 방문하지 않았으면 dfs 시작
                dfs(i);
            }
        }
    }

    public static void bfs(int x){
        visited[x] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i=1; i<=N; i++){
                if(!visited[i] && graph[node][i] == 1){ //i는 가야할 곳, node는 현재 위치
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}