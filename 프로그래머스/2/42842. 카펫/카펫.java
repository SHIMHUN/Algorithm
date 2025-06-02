class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자 수

        // 세로는 최소 3부터 시작 (가로 >= 세로)
        for (int height = 3; height <= Math.sqrt(total); height++) {
            if (total % height == 0) {
                int width = total / height;
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}