import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n==0) System.out.println("0");
        else if(n%2==0) System.out.println((n/2) * (n+1));
        else System.out.println((n/2)*(n+1)+(n/2+1));
	}
}