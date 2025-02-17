import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static int[] hackedCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1]; // 1-based index
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 방향을 뒤집어서 저장 (B가 A를 신뢰 -> A에서 B로 이동 가능)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        hackedCount = new int[N + 1];

        int maxCount = 0;
        List<Integer> result = new ArrayList<>();

        // BFS 실행하여 해킹 가능한 개수 찾기
        for (int i = 1; i <= N; i++) {
            int count = bfs(i);
            hackedCount[i] = count;
            maxCount = Math.max(maxCount, count);
        }

        // 최대 개수를 가진 노드들 찾기
        for (int i = 1; i <= N; i++) {
            if (hackedCount[i] == maxCount) {
                result.add(i);
            }
        }

        // 오름차순 정렬 후 출력
        Collections.sort(result);
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    // BFS 탐색
    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(start);
        visited[start] = true;
        int count = 1; // 자기 자신도 포함

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
