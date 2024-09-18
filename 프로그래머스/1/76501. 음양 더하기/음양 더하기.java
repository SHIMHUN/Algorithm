class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            int n = (signs[i] == false)? absolutes[i] * -1 : absolutes[i];
            // if(signs[i] == false){
            //     n = absolutes[i] * -1;
            // }else{
            //     n = absoulte
            // }   
            answer += n;
        }
        return answer;
    }
}