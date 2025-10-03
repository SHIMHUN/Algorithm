import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            
        	int A = P*W;
            int B;
            
        	if(W <= R) B = Q;
            else B = (W-R)*S + Q;
        
        	int result = Math.min(A,B);
        	sb.append("#" + i + " " + result + "\n");
        
        }
        System.out.println(sb);
	}
}