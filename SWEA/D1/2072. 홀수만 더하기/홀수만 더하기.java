import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=T; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int sum=0;
            for(int j=0; j<10; j++){
            	int num = Integer.parseInt(st.nextToken());
                
                if(num % 2 != 0)  sum+=num;
            }
            sb.append("#"+i+" "+sum+"\n");
        }
        
        System.out.println(sb);
	}
}