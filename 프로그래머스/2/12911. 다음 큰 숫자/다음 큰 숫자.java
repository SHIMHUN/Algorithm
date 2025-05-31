class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = Integer.bitCount(n); //bitCount는 이진수에서 1의 갯수를 반환해주는 함수이다
        
        while(true){
            int next = Integer.bitCount(++n);
            if(start == next){ //1의 갯수가 같다면 루프 종료
                answer = n;
                break;
            }
        }
        return answer;
    }
}