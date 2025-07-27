class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        while(start < end){
             mid = start + (end - start)/2;
                
            if(nums[mid] < nums[end]){ //mid 지점이 현재 min의 왼쪽 영역에 위치
                end = mid;    
            }else{ //mid 지점이 현재 min의 오른쪽 영역에 위치
                start = mid + 1;
            }
        }
        return nums[start];
    }
}