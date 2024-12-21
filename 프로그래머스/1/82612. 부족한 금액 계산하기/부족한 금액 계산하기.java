class Solution {
    public long solution(int price, int money, int count) {
        long sum=0;
        
        for(int i=1; i<count+1; i++){
            sum+=price*i;
            // money -= 
        }
        
        long answer = sum - money;
        
        return (answer > 0 )? sum - money : 0;
        
//         long answer = -1;

//         return answer;
    }
}