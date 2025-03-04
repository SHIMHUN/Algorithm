import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] size;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        size = new int[N][2];

        //배열 채우기
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            size[i][0] = x;
            size[i][1] = y;
        }

//        for(int[] arr : size){
//            for(int ele : arr){
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }

        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++){
                if(j != i){
                    if(size[j][0] > size[i][0] && size[j][1] > size[i][1]){ //기준점이 덩치가 더 큰 경우
                        rank++;
                    }
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}