class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            // int n = (signs[i] == false)? absolutes[i] * -1 : absolutes[i];
            // answer += n;
            answer += (signs[i] == false)? absolutes[i] * -1 : absolutes[i];
        }
        return answer;
    }
}