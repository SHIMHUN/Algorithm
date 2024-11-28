import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length ==1){
            int[] empty = new int[]{-1};
            return empty;
        }
        
        int[] answer = new int[arr.length-1];
        int min_val = arr[0];
        int idx = 0;
        for(int i=1; i<arr.length; i++){
            if(min_val > arr[i]){
                min_val = arr[i];
                idx = i;
            }
        }
        
        // for(int i=0; i<arr.length-1; i++){
        //     if(idx != i){
        //         answer[i] = arr[i];
        //     }
        // }
        
        int j = 0; // answer 배열의 인덱스
        for (int i = 0; i < arr.length; i++) {
            if (i != idx) { // 최소값의 인덱스는 건너뛴다
                answer[j++] = arr[i];
            }
        }

        return answer;
    }
}