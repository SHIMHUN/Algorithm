class Solution {
    public String solution(int n) {
        String answer = "";
        
        if(n%2 == 0){ //짝수일때
            answer+="수박".repeat(n/2);
        }else{ //짝수일 때
            answer+="수박".repeat(n/2)+"수";
        }
        
        // for(int i=0; i<n; i++){
        //     if(i)
        // }
        
        return answer;
    }
}