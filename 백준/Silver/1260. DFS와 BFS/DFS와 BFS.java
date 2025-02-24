import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N,M,V;
    static String[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); //정점 개수
        M = Integer.parseInt(s[1]); //간선 개수
        V = Integer.parseInt(s[2]); //시작 정점

        graph = new ArrayList[N + 1]; // 1-based index
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph[a].add(b);
            graph[b].add(a); // 양방향 그래프
        }

        // 번호가 작은 정점부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS 실행
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());
    }

    // DFS (재귀)
    static void dfs(int node) {
        visited[node] = true; //노드 방문 처리
        sb.append(node).append(" ");

        for (int next : graph[node]) { //해당 노드를 기준으로 정점 선택
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS (큐 사용)
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); //시작 정점을 큐에 추가
        visited[start] = true; //방문 처리

        /*
        * 큐에 들어있는 모든 정점을 꺼내고 각 정점마다 연결되어있는 점들을 탐색
        * */
        while (!queue.isEmpty()) {
            int node = queue.poll(); //큐에 들어있는 원소 제거 및 반환
            sb.append(node).append(" ");

            /*
            * 한 사이클이 종료되면 기준 정점에 연결되어있는 모든 정점들이 큐에 추가되어있음
            * */
            for (int next : graph[node]) { //헤딩 노드와 연결되어있는 정점 탐색
                if (!visited[next]) { //방문하지 않았다면 방문처리하고 큐에 추가
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
