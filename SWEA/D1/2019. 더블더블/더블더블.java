import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int prev = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=n; i++){
            sb.append(prev + " ");
            prev= prev*2;
        
        }
        System.out.print(sb);
	}
}