import java.util.*;


class Solution {
    static HashSet<Integer> set = new HashSet<>();

    public Integer[] solution(int[] numbers) {
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        return arr;
        // int[] answer = {};
        // return answer;
    }
}