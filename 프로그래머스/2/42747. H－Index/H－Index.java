import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순 정렬

        int h = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }

        return h;
    }
}