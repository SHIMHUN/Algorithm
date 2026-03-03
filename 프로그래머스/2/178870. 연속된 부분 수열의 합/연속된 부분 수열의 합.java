class Solution {
    int[] result = {0, 0};
    
    public int[] solution(int[] sequence, int k) {
        int right = 0;
        int left = 0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        
        while(right<sequence.length){
            sum+=sequence[right++];

            while(sum>=k){
                if(sum==k && (right-left)<minLen){
                    minLen=right-left;
                    result[0]=left;
                    result[1]=right-1; //-1을 하는 이유: result에 저장되는 시점에는 right가 이미 ++되었기 때문
                }
                sum-=sequence[left++];
            }
        }

        return result;
    }
}