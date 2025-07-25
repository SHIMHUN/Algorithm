// import java.util.*;

class Solution {
    public int findPeakElement(int[] nums) {


        if(nums.length == 1) return 0; //배열에 값 하나일때

        int n = nums.length;

        if(nums[0] > nums[1]) return 0; //첫번째가 peak인 경우 바로 리턴
        if(nums[n-1] > nums[n-2]) return n-1; //마지막이 peak인 경우 바로 리턴

        //첫번째, 마지막번째가 peak인 경우는 제외하고 이분 탐색
        int start = 1;
        int end = n-2;

        while(start < end){
            int mid = start + (end-start)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid-1]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}