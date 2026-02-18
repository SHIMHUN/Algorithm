class Solution {
    
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        
        //dp 초기화
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                int max = 0;
                
                //dp값 업데이트
                for(int k=0; k<4; k++){
                    if(k==j) continue;
                    max = Math.max(max, dp[i-1][k]); //이전까지의 최댓값과 max 비교
                }
                
                //이전까지의 최댓값 + 현재 밟고 있는 칸 점수
                dp[i][j] = land[i][j] + max;
            }
        }
        
        int answer = 0;
        for(int j=0; j<4; j++){
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        return answer;
    }

}