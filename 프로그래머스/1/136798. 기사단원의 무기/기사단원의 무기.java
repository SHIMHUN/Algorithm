import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //주어진 수만큼 약수 구하기
        for(int i=1; i<=number; i++){
            int div_cnt = divisor(i);
            
            if(div_cnt > limit){//약수가 제한 수치 넘는지 검사
                answer+=power;
            }else{
                answer+=div_cnt;
            }
        }
        // System.out.println(divisor(6)+1);
        return answer;
    }
    
    //약수 구하는 함수
    static int divisor(int num){
        int result = 0;
        
        for(int i=1; i<=num/2; i++){    
            int div = num%i;
            
            if(div == 0){

                result+=1;
            }
        }
        return result+1;
    }
}