import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N==1){
        	System.out.println("1");
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<=N/2; i++){
            if(N%i==0){
            	list.add(i);
            }
        }
        
        list.add(N);
        //Collections.sort(list);
        StringBuilder sb = new StringBuilder();
         for(int ele : list){
         	sb.append(ele + " ");
         }
        System.out.println(sb);
    }
}