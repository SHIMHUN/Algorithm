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
        	String encodedStr = br.readLine();
            byte[] bytes = Base64.getDecoder().decode(encodedStr);
            String originStr = new String(bytes);
            sb.append("#" + i + " " + originStr + "\n");
        }
        System.out.println(sb);
	}
}