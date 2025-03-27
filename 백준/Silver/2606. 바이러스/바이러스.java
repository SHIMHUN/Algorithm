import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int n, result = 0;

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 그래프그리기
        for(int j = 0; j < m; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }

        bfs(1);
        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] virus = new boolean[n+1];
        virus[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int x : arr[now]) {
                if(virus[x] == false) {
                    virus[x] = true;
                    result++;
                    queue.add(x);
                }
            }
        }
    }
}