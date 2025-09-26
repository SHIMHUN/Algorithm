import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int sum = 0;
            for(int i=1; i<=N; i++){
            	if(i%2 == 0 ) sum-=i;
                else sum+=i;
            }
            sb.append("#" + test_case+ " " +sum + "\n");
		}
        System.out.println(sb);
	}
}