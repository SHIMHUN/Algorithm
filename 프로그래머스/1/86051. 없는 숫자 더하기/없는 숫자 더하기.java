class Solution {
    public int solution(int[] numbers) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        
        for(int element:numbers){
            arr[element] = 0;
        }
        
        int sum = 0;
        for(int element:arr){
            // System.out.println(element);
            sum += element;
        }
        return sum;
    }
}