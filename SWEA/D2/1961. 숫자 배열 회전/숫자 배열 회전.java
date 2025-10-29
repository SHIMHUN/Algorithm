import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] original = new int[N][N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int z = 0; z < N; z++) {
                    original[j][z] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] rotate90 = new int[N][N];
            int[][] rotate180 = new int[N][N];
            int[][] rotate270 = new int[N][N];
            
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    rotate90[y][N-1-x] = original[x][y];
                    rotate180[N-1-x][N-1-y] = original[x][y];
                    rotate270[N-1-y][x] = original[x][y];
                }
            }
            
            sb.append("#").append(i+1).append("\n");
            for (int j = 0; j < N; j++) {
                for (int z = 0; z < N; z++) sb.append(rotate90[j][z]);
                sb.append(" ");
                for (int z = 0; z < N; z++) sb.append(rotate180[j][z]);
                sb.append(" ");
                for (int z = 0; z < N; z++) sb.append(rotate270[j][z]);
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}