import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int n;
    static boolean visited[];
    static int sum=-1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[child][parent] = 1;
            graph[parent][child] = 1;
        }

        dfs(firstNum, secondNum,0);

        System.out.println(sum);

    }

    public static void dfs(int curr, int target, int count){
        if(curr == target) {
            sum = count;
            return; //상대를 만난 경우
        }

        visited[curr] = true;

        for(int i=1; i<=n; i++){
            if(!visited[i] && graph[curr][i] == 1){ //다음 장소로 이동할 수 있는 경우
                dfs(i,target, count+1);
            }
        }
    }
}