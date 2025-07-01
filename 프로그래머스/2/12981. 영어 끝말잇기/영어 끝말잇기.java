import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] result = {0, 0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];

            // 끝말잇기 실패
            if (prev.charAt(prev.length() - 1) != curr.charAt(0) || set.contains(curr)) {
                result[0] = (i % n) + 1;  // 사람 번호
                result[1] = (i / n) + 1;  // 차례
                return result;
            }

            set.add(curr);
        }

        return result;  // 규칙 위반 없을 경우 [0, 0]
    }
}