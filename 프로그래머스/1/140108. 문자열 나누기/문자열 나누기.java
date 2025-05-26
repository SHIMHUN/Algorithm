class Solution {
    public int solution(String s) {
//         String word = s;
//         int answer = 0;
//         while(!word.isEmpty()){
//             char start = word.charAt(0); //시작 문자 추출 
//             int correct_cnt=0;
//             int not_correct_cnt=0;  
            
//             int i = 0;
//             for(; i<word.length(); i++){
//                 if(word.charAt(i) == start){
//                     correct_cnt++;
//                 }
//                 else{
//                     not_correct_cnt++;
//                 }
//                 if(correct_cnt == not_correct_cnt){
//                     break;
//                 }
//             }

//             answer++;
//             if(i+1 < word.length()){
//                 word = word.substring(i+1);    
//             }else{
//                 break;
//             }
//         }
        
        int answer = 0;
        char init = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (count == 0) {
                init = c;
            }
            if (init == c) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                answer++;
            }
        }

        if(count > 0) {
            answer++;
        }
        return answer;
    }
}