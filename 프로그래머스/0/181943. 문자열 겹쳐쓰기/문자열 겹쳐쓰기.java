class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        char b;
        for(int i=0; i<s; i++){
            b = my_string.charAt(i);
            answer += b;
        }
        answer+=overwrite_string;
        
        for(int i=s+overwrite_string.length(); i<my_string.length(); i++){
            b = my_string.charAt(i);
            answer += b;
        }
        return answer;
    }
}