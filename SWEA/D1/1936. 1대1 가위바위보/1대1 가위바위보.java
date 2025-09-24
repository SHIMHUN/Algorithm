import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        Map<Integer,String> map = new HashMap<>();
        map.put(A, "A");
        map.put(B, "B");
        
		int diff = Math.abs(A-B);
        
        if(diff == 2) {
           int result = (A>B)? B:A;
           System.out.println(map.get(result));
        }
        else {
            int result = (A>B)? A:B;
           System.out.println(map.get(result));
        }
	}
}