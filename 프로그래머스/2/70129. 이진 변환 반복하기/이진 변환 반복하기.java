class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int remove_cnt = 0;
        int loop_cnt = 0;

        //이진 변환 루프
        while(!s.equals("1")){
            int before = s.length();
            s=s.replace("0","");
            int after = s.length();
            
            //제거된 0의 갯수 갱신
            remove_cnt += (before - after);
            
            int cnt=0;
            String temp = "";
            while(after>1){
                
                temp = (after%2) + temp;
                after/=2;
                
                cnt++;
            }
            
            s= "1"+temp;
            loop_cnt++;
        }
        
        answer[0] = loop_cnt;
        answer[1] = remove_cnt;
        return answer;
    }
}