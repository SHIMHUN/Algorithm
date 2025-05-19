class Solution {
    static String[] pronunciation = {"aya", "ye", "woo", "ma"};
    static String word = "";
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            int cnt = 0; //모든 옹알이에 대해서 연속된 단어가 없어야 함 -> 0
            
            if(word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("mama")) {
                continue;
            }
            
            for(String s : pronunciation){
                word = word.replace(s," ");
                // if(word.matches(".*\\s{2,}.*")){//연속된 단어가 있는지
                //     cnt++;
                // } 
            }
            
            word = word.replace(" ","");
            if(word.length() == 0){
                answer++;
            }
        }
        return answer;
    }
}