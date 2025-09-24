class Solution
{
	public static void main(String args[]) throws Exception
	{	
        
        StringBuilder sb = new StringBuilder();
		for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                char c;
                if(i==j) c='#';
                else c='+';
                sb.append(c);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
	}
}