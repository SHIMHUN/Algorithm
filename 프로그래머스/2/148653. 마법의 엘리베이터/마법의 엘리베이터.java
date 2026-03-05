class Solution {
    public int solution(int storey) {
        int totalCnt=0;
        
        while(storey > 0){
            int num = storey % 10;
            storey/=10;
            
            if(num > 5) {
                totalCnt+=(10-num);
                storey++;
            }
            else if(num <5) totalCnt+=num;
            else{ //num==5인 경우 올리는 비용, 내리는 비용이 같으므로 다음 carry를 보고 결정
                if(storey % 10 >= 5){
                    totalCnt+=5;
                    storey++;
                }else{
                    totalCnt+=5;
                }
            }
        }
        return totalCnt;
    }
}