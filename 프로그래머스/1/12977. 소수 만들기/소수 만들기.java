class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int z=j+1; z<nums.length; z++){
                    if(isPrime(nums[i]+nums[j]+nums[z])){
                        answer++;
                    }
                }
            }
        }
        

        return answer;
    }
    
    boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}