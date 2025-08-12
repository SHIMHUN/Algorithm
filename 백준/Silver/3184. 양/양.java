import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] graph;
    static boolean[][] visited;

    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};

    static int totalSheepCnt = 0;
    static int totalWolfCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                graph[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && graph[i][j] != '#'){
                    Animal animal = dfs(i,j);

                    if(animal.sheepCnt > animal.wolfCnt){
                        totalSheepCnt+=animal.sheepCnt;
                    }else if(animal.sheepCnt <= animal.wolfCnt){
                        totalWolfCnt+=animal.wolfCnt;
                    }
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    static Animal dfs(int row, int col){
        visited[row][col] = true;

        Animal animal = new Animal(0,0);
        if(graph[row][col] == 'o'){
            animal.sheepCnt=1;
        }else if(graph[row][col] == 'v'){
            animal.wolfCnt=1;
        }

        for(int i=0; i<=3; i++){
            int newX = row+dx[i];
            int newY = col+dy[i];

            if(rangeCheck(newX, newY) && !visited[newX][newY]){
                Animal next = dfs(newX, newY);
                animal.sheepCnt+=next.sheepCnt;
                animal.wolfCnt+=next.wolfCnt;
            }
        }
        return animal;
    }

    static class Animal{
        int wolfCnt;
        int sheepCnt;

        Animal(int wolfCnt, int sheepCnt){
            this.wolfCnt = wolfCnt;
            this.sheepCnt = sheepCnt;
        }
    }

    static boolean rangeCheck(int row, int col){
        return row>=0 && col>=0 && row<R && col<C && graph[row][col] != '#';
    }
}