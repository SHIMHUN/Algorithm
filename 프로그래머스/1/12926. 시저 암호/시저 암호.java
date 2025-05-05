class Solution {
    public String solution(String s, int n) {
    
        String answer = "";

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                answer += ' ';
            }else if(Character.isUpperCase(c)){
                answer += (char)((c - 'A' + n)%26 + 'A');
                
            }else{
                answer += (char)((c - 'a' + n)%26 + 'a');
            }
            
        }
        
        return answer;
    }
}