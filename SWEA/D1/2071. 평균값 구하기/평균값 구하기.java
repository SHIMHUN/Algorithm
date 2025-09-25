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
            int sum = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
            	sum += Integer.parseInt(st.nextToken());
            }
            
            int avg=0;
            
            if(sum%10 >= 5) avg = sum/10 + 1;
            else avg = sum/10;
            sb.append("#" + i + " " + avg + "\n");
        }
        System.out.println(sb);
	}
}