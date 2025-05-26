class Solution {
    public int solution(String s) {
        String word = s;
        int answer = 0;

        while(!word.isEmpty()){
            char start = word.charAt(0); //시작 문자 추출 
            int correct_cnt=0;
            int not_correct_cnt=0;  
            
            int i = 0;
            for(; i<word.length(); i++){
                if(word.charAt(i) == start){
                    correct_cnt++;
                }
                else{
                    not_correct_cnt++;
                }
                if(correct_cnt == not_correct_cnt){
                    break;
                }
            }

            answer++;
            if(i+1 < word.length()){
                word = word.substring(i+1);    
            }else{
                break;
            }
        }
        
        return answer;
    }
}