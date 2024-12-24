import java.util.*;

// class Solution {
//     public int solution(int[] number) {
//         int answer = 0;
        
//         for(int i=0; i<number.length-2; i++){
//             for(int j=i+1; j<number.length-1; j++){
//                 for(int z=j+1; z<number.length; z++){
//                     if(number[i]+number[j]+number[z] == 0){
//                         answer++;
//                     }
//                 }
//             }
//         }
        
//         return answer;
//     }
// }

class Solution {
    static int count; // 삼총사의 개수를 저장

    public int solution(int[] number) {
        count = 0; // 초기화
        dfs(number, 0, 3, 0); // DFS 탐색 시작
        return count; // 삼총사의 개수 반환
    }

    public static void dfs(int[] number, int start, int r, int sum) {
        // 조합이 완성된 경우
        if (r == 0) {
            if (sum == 0) { // 합이 0이면 삼총사
                count++;
            }
            return;
        }

        // 조합 생성
        for (int i = start; i < number.length; i++) {
            dfs(number, i + 1, r - 1, sum + number[i]); // 숫자를 선택하고 다음 단계로
        }
    }
}