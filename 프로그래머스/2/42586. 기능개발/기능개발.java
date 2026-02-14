import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        int n = progresses.length;
        int[] days = new int[n];

        // 1. 각 작업 완료까지 걸리는 일수 계산
        for (int i = 0; i < n; i++) {
            days[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }

        // 2. 배포 묶음 계산
        List<Integer> result = new ArrayList<>();

        int current = days[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (days[i] <= current) {
                count++;
            } else {
                result.add(count);
                current = days[i];
                count = 1;
            }
        }

        result.add(count);

        // 3. List → 배열 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}