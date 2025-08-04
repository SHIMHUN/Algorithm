import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited; //노드당 방문여부 저장
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            //무방향 그래로 정의하고 부모 구하기
            graph[x].add(y);
            graph[y].add(x);
        }
        dfs(1);

        for(int i=2; i< result.length; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int n) {
        visited[n] = true;

        for (int next : graph[n]) {
            if (!visited[next]) {
                result[next] = n;
                dfs(next);
            }
        }
    }
}