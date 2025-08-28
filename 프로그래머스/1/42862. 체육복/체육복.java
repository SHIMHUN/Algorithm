import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n+1]; //0..n
        int cnt=0;
        
        Arrays.fill(clothes, 1);
        
        // 체육복 잃어버린 사람
        for(int i : lost) clothes[i]--;
        
        // 여벌 체육복이 있는 사람
        for(int i : reserve) clothes[i]++;
        
        for(int i=1; i<=n; i++){
            
            // 체육복 없는 경우 
            if(clothes[i] == 0){
                if(i>=1 && clothes[i-1]==2){ // 앞사람에게 체육복 빌릴 수 있는지
                    clothes[i-1]--;
                    clothes[i]++;
                }else if(i<n && clothes[i+1]==2){ // 뒷사람에게 체육복 빌릴 수 있는지
                    clothes[i+1]--;
                    clothes[i]++;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(clothes[i]>=1) cnt++;
        }
        
        return cnt;
    }
}