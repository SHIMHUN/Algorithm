import java.io.*;

class Solution
{	
    static boolean checkMonth(int month){
    	return month >= 1 && month <=12;
    }
    
    static boolean checkDay(int month, int day){
        if(month == 2){
        	return day >= 1 && day <= 28;
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
        	return day >= 1 && day <= 30;
        }else{
            return day >= 1 && day <= 31;
        }
	
    }
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++){
        	String s = br.readLine();
			
            String year = s.substring(0,4);
            String month = s.substring(4,6);
            String day = s.substring(6,8);
            
            if(!checkMonth(Integer.parseInt(month))){
                sb.append("#"+i +" -1"+"\n");
            	continue;
            }if(!checkDay(Integer.parseInt(month), Integer.parseInt(day))) {
            	sb.append("#"+i +" -1"+"\n");
            	continue;
            }

            String fullDate = year + "/" + month + "/" + day;
            sb.append("#"+i +" "+fullDate+"\n");
        }
        
        System.out.println(sb);
	}
}