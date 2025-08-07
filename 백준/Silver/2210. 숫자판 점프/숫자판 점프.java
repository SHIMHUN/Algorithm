import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[5][5];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i, j, 0, board[i][j]+"");
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int x, int y, int depth, String s){
        if(depth == 5){
            set.add(s);
            return;
        }
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(rangeCheck(newX, newY)){
                dfs(newX, newY, depth+1, s+board[newX][newY]);
            }
        }
    }

    public static boolean rangeCheck(int x, int y){
        return x>=0 && y>=0 && x<5 && y<5;
    }
}