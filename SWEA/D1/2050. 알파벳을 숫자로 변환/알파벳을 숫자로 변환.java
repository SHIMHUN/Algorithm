import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine().toUpperCase();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
            int num = c-'0'-16;
            sb.append(num + " ");
        }
        
        System.out.println(sb);
	}
}