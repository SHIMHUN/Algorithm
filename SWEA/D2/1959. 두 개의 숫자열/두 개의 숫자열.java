import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
            	A[j] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
            	B[j] = Integer.parseInt(st.nextToken());
            }
            
            int max = 0;
            if(N>=M){
                for(int j=0; j<=N-M; j++){
                    int sum = 0;
                    for(int z=0; z<M; z++){
                        sum += B[z] * A[z+j];
                    }
                    max = Math.max(max, sum);
                }
            }else{
                for(int j=0; j<=M-N; j++){
                    int sum = 0;
                    for(int z=0; z<N; z++){
                        sum += A[z] * B[z+j];
                    }
                    max = Math.max(max, sum);
                }
            }    

            sb.append("#" + i + " " + max + "\n");
        }
		System.out.println(sb);
	}
}