
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] trees = new int[N];
        int up = 0, down = 0; // 나무 최대, 최소 높이

        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(st.nextToken());

            if(up < trees[i]){ //최대 높이갱신
                up = trees[i];
            }
        }

        while(down < up){
            int mid = (down + up)/2;
            long sum = 0;

            for(int tree : trees){
                if(tree - mid > 0){
                    sum += tree - mid; // 나무가 기준 높이보다 높으면 자름
                }
            }
            
            /*
            * 잘랐는데 필요한 나무 높이의 합보다 작으면 더 잘라야 함
            * 그 반대면 덜 잘라야 함
            * */
            if(sum < M){ 
                up = mid; 
            }else{
                down = mid +1;
            }
        }

        System.out.println(down-1);

    }
}