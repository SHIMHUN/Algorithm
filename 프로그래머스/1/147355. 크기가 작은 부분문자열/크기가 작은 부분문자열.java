class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for(int i=0; i <= t.length()-p.length(); i++){
            String str = t.substring(i, i+p.length());

            Long a=Long.parseLong(p);
            Long b=Long.parseLong(str);
            if(a>=b){
                answer++;
            }
        }
        
        return answer;
    }
}