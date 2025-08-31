import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder("");
        int len = number.length()-k; //만들어야 할 길이
        int start = 0;
        
        //시작 인덱스가 범위를 벗어나지 않으며 아직 정답 문자열이 완성되지 않은 경우 루프 실행
        while(start < number.length() && answer.length() != len){
            int leftNum = k + answer.length() + 1;
            int max = 0;
            
            // 탐색해야할 범위 조정
            for(int j=start; j<leftNum; j++){
                if(max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';//최댓값 찾음
                    start = j+1; //시작 인덱스 갱신
                }
            }
            answer.append(Integer.toString(max));
        }
        
        return answer.toString();
    }
}