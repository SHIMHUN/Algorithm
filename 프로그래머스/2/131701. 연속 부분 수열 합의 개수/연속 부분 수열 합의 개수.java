import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        
        // 1. 배열 2배로 확장
        int[] extended = new int[n*2];
        for(int i=0; i<n*2; i++){
            extended[i] = elements[i%n];
        }
        
        // 2. 누적 합 구해놓기
        int[] sum = new int[2*n];
        sum[0] = elements[0];
        for(int i=1; i<2*n; i++){
            sum[i] = sum[i-1] + extended[i];
        }
        
        // 3. 시작, 끝 인덱스에 해당하는 누적 값 빼주기
        for(int i=1; i<=n; i++){
            for(int j=0; j<n; j++){
                int result = sum[j+i] - sum[i];
                set.add(result);
            }
        }

        int answer = set.size();
        return answer;
    }
}