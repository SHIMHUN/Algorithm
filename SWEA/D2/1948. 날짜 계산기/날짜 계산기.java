import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,31);
        map.put(2,28);
        map.put(3,31);    
        map.put(4,30);
        map.put(5,31);
        map.put(6,30);
        map.put(7,31);
        map.put(8,31);
        map.put(9,30);
        map.put(10,31);
        map.put(11,30);
        map.put(12,31);
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테케 갯수
        
        for(int i = 1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int beforeMonth = Integer.parseInt(st.nextToken());
            int beforeDate = Integer.parseInt(st.nextToken());
            int afterMonth = Integer.parseInt(st.nextToken());
            int afterDate = Integer.parseInt(st.nextToken());
            
            int count = 0;
            
            if(beforeMonth == afterMonth){ 
                count = afterDate - beforeDate + 1;
            }else{
                for(int j=beforeMonth+1; j<afterMonth; j++){
                	count += map.get(j);
                }
                
                count+=map.get(beforeMonth)-beforeDate+1;
                count+=afterDate;
            }
            
            sb.append("#"+i+" "+count+"\n");
        }
        System.out.println(sb);
	}
}