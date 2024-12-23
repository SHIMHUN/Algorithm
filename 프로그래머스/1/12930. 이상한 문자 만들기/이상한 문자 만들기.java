class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        int cnt = 0;
        
        while(true){
            // System.out.println(s.charAt(idx));
            if(idx == s.length()){
                break;
            }
            
            if(s.charAt(idx) != ' '){
                if(cnt % 2 == 0){
                    answer += Character.toUpperCase(s.charAt(idx));
                }else{
                    answer += Character.toLowerCase(s.charAt(idx));
                }
                
                cnt++;
            }else{
                answer += ' ';
                cnt = 0;
            }
            
            idx++;
        }
        
        return answer;
    }
}

        // String[] words = s.split("\\s+");
        
        // System.out.println(s);
        
        // for(int i=0; i<words.length; i++){
        //     for(int j=0; j<words[i].length(); j++){
        //         if(j%2 == 0){
        //             answer+=Character.toUpperCase(words[i].charAt(j));
        //         }else{
        //             answer+=Character.toLowerCase(words[i].charAt(j));
        //         }
        //     }
        //     if(i != words.length-1){
        //        answer+=" "; 
        //     }
        // }
        
//         for(int i=0; i<s.length(); i++){
//             while(true){
                
//             }
//         }