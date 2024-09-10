import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String nums;
        
        nums = String.valueOf(n);
        char num;
        for(int i=0; i<nums.length(); i++){
            // num = nums.charAt(i);
            // int n = Character.intValue(num);
            // System.out.println(num);
            // cout << num << endl;
            answer += Integer.parseInt(String.valueOf(nums.charAt(i)));
            
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}