import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        long max = 0;

        for(int i=0; i<K; i++){
            lans[i] = Integer.parseInt(br.readLine());
            if(max < lans[i]){
                max = lans[i];
            }
        }

        max++;
        long min = 0;
        long mid = 0;

        while(min < max){
            mid = (min + max)/2;
            long cnt = 0;

            for(int lan : lans){
                cnt+=lan/mid;
            }

            if(cnt<N){
                max = mid;
            } else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}