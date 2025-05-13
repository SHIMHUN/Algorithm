class Solution {
    static int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
    static String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    
    public String solution(int a, int b) {
        String answer = "";
        
        int day_cnt = 0;
        
        for(int i=0; i<a-1; i++){
            day_cnt += months[i];
        }
        
        day_cnt += b;
        
        return days[(day_cnt-1) % 7];
        
        // return answer;
    }
}