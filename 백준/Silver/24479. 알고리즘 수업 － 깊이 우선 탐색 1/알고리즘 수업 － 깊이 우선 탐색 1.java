import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, count=1;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] order;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N+1];
        order = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());
            graph.get(firstNum).add(secondNum);
            graph.get(secondNum).add(firstNum);
        }
        // 오름차순 정렬 (문제 조건)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++){
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int curr){
        visited[curr] = true;
        order[curr] = count++;

        for(int next : graph.get(curr)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}