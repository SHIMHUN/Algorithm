class Solution {
    public long solution(long num) {
        int answer = 0;
        if(num == 1){
            return 0;
        }
        
        while(answer < 500){
            if(num == 1){
                return answer;
            }
            
            if(num % 2 == 0){
                num /= 2;
            }
            else{
                num *= 3;
                num += 1;
            }
            
            answer++;
        }
        return -1;
    }
}