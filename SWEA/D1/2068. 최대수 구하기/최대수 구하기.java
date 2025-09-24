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
            int max = Integer.MIN_VALUE;
            for(int j=0; j<10; j++){
                int num = Integer.parseInt(st.nextToken());
                if(max<num) max = num;
            }
            sb.append("#" + i + " " + max).append("\n");
		}
        
        System.out.println(sb);
    }
}