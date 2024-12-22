class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");    
        
        int[] nums = new int[str.length];
        
        for(int i=0; i<str.length; i++){
            nums[i] = Integer.parseInt(str[i]);
        }
        
        
        int min = nums[0];
        int max = nums[0];
        
        for(int i=1; i<str.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
            
            if(nums[i] > max){
                max = nums[i];
            }
        }
        
        return min + " " + max;
        
        // Arrays.sort(nums);
        
        // String answer = "";
        // return answer;
    }
}