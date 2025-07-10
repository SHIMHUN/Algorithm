//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.util.*;

public class Main {
    static int[][] square;
    static int N, white=0, blue=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        square = new int[N][N];

        // 초기 2차원 배열 세팅
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(s[j]);
                square[i][j] = num;
            }
        }

        check(0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    public static void check(int x, int y, int n){

        boolean isWhite = true;
        boolean isBlue = true;

        // 전체 색칠되있거나 안칠해져있는지 확인
        loop1:
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(square[i][j] != 0){
                    isWhite=false;
                    break loop1;
                }
            }
        }

        if(isWhite == true) {
            white++;
            return;
        }

        loop2:
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(square[i][j] != 1){
                    isBlue=false;
                    break loop2;
                }
            }
        }

        if(isBlue==true){
            blue++;
            return;
        }

        int length = n/2;

        check(x, y, length);
        check(x+length, y, length);
        check(x, y+length, length);
        check(x+length, y+length, length);
    }
}