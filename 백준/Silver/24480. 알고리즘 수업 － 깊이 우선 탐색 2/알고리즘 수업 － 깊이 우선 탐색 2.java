import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int N, M, R, count=1;
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());

            int firstPoint = Integer.parseInt(st.nextToken());
            int secondPoint = Integer.parseInt(st.nextToken());
            graph.get(firstPoint).add(secondPoint); //무방향 그래프
            graph.get(secondPoint).add(firstPoint);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int curr){
        visited[curr] = true;
        result[curr] = count++;
        Collections.sort(graph.get(curr), Collections.reverseOrder()); //역순 재정렬

        for(int next :graph.get(curr)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}