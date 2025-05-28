class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        
        for(int i=0; i<words.length; i++){
            if(words[i].length() == 0){
                answer+= " ";
                continue;
            }
            String word = words[i];
            // String first = String.valueOf(Character.toUpperCase(word.charAt(0)));
            answer+=word.substring(0,1).toUpperCase();
            // String second = "";
            
            // for(int j=1; j<word.length(); j++){
            //     second+=Character.toLowerCase(word.charAt(j));
            // }
            answer+=word.substring(1, word.length()).toLowerCase();
            answer+=" ";
            // answer+=(first+second);
            // if(i != words.length-1){
            //     answer+=" ";
            // }
        }
        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
    	if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}
    	
    	// 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
        
        // return (answer.charAt(answer.length()-1) == ' ') ? answer.substring(0, answer.length()-1) : answer;
    }
}