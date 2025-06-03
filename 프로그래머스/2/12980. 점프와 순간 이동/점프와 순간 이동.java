import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n>0){
            ans+=n%2; //순간이동 하고나서 이동하는 칸의 수
                
            n/=2; //순간이동 전으로 워프
        }

        return ans;
    }
}