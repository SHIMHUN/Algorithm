class Solution {
    static int count = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {   
        this.numbers=numbers;
        this.target=target;
        dfs(0, 0);
        
        return count;
    }
    
    public void dfs(int sum, int idx){
        if(idx==numbers.length){
            if(sum==target) count++;
            return;
        }
        dfs(sum+numbers[idx], idx+1);
        dfs(sum-numbers[idx], idx+1);
    }
}