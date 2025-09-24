import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int sum = 0;
        
        for(int i=0; i<N.length(); i++){
       		sum+=Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        
        System.out.println(sum);
	}
}