class Solution {
    static int DP[];
    
    public int solution(int n) {
        DP = new int[n+1];
        DP[0] = 0;
        DP[1] = 1;
        
        for(int i=2; i<=n; i++){
            DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
        }
        // return DP[n] % 1234567;
        return DP[n];
    }
}