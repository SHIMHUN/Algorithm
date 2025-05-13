import java.util.*;


class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] nums) {
        for(int num : nums){
            set.add(num);
        }
        
        int answer = 0;
        int num = nums.length/2;
        int size = set.size();
        
        if(size >= num){
            answer = num;
        }else{
            answer = size;   
        }
        
        return answer;
        // return 0;
    }
}