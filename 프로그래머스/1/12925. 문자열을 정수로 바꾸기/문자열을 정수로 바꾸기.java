class Solution {
    public int solution(String s) {
        int answer = 0;
        int conv = 0;
        if(s.charAt(0) == '-'){
            conv = Integer.parseInt(s.substring(1));
            conv *= -1;
            // s.substr(0);
        }else{
            conv = Integer.parseInt(s);
        }
        return conv;
    }
}