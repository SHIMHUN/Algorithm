class Solution {
    static long DP[];
    
    public long solution(int n) {
        // 크기를 n+2로 설정한 이유 -> n이 1인 경우 고려, i가 3부터 시작하므로 DP[3]을 위한 공간 확보
        // n+1로 설정한다면? -> n이 1일때 n+1은 2이므로 i가 3부터 시작하는데 DP[3]에 해당하는 공간 없음
        DP = new long[n+2]; 
        DP[1] = 1; // 1칸 뛰는 경우의 수: 1
        DP[2] = 2; // 2칸 뛰는 경우의 수: 1+1, 2
        
        for(int i=3; i<=n; i++){
            DP[i] = (DP[i-1] + DP[i-2])% 1234567;
        }
        return DP[n];
    }
}