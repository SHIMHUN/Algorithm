class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        //1. 1번 인덱스부터 배열 돌면서 2로 나눈 몫 구하기
        for(int i=1; i<food.length; i++){
            int loop = food[i]/2;
            for(int j=0; j<loop; j++){
                answer+=i;
            }
        }
        
        //2. 결과 문자열 뒤집기
        StringBuilder sb = new StringBuilder(answer);
        String reversed = sb.reverse().toString();
        
        //3. 첫 결과 문자열에 0 추가하고 뒤집은 문자열 붙이기
        answer+='0';
        answer+=reversed;
        
        return answer;
    }
}