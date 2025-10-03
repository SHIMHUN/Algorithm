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
        	Deque<Character> dq = new ArrayDeque<>();
            String s = br.readLine();
            boolean flag = true;
            
            for(char c : s.toCharArray()){
            	dq.offerLast(c);
            }
            
            while(dq.size() >= 2){
            	char first = dq.removeFirst();
                char last = dq.removeLast();
                
                if(first != last){
                	sb.append("#" + i + " " + 0 + "\n");
                    flag = false;
                	break;
                }
            }
            
            if(flag == true) sb.append("#" + i + " " + 1 + "\n");
        }
        
        System.out.println(sb);
	}
}