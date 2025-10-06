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
        	int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int j=0; j<N; j++){
            	arr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            
            sb.append("#"+i+" ");
        	for(int j=0; j<N; j++){
                sb.append(arr[j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
	}
}