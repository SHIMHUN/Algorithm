class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        String[] words = my_string.split(letter);
        
        for(int i=0; i<words.length; i++){
            answer+=words[i];
        }
        
        return answer;
    }
}