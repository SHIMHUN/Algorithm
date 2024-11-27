import java.util.*;

class Solution {
    public Vector<Integer> solution(int[] arr, int divisor) {
        int[] answer = {};
        Vector<Integer> vec = new Vector<>(arr.length);
        for(Integer element : arr){
            if(element % divisor == 0){
                vec.add(element);
                System.out.println(element);
            }
        }
        
        Collections.sort(vec);
        if(vec.size() == 0){
            vec.add(-1);
        }
        return vec;
    }
}