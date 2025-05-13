import java.util.*;


class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] nums) {
        for(int num : nums){
            set.add(num);
        }
        
        return (set.size() >= nums.length/2)? nums.length/2 : set.size();
    }
}