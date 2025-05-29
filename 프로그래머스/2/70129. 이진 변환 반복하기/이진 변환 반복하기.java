class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int removeCnt = 0;
        int loopCnt = 0;

        //이진 변환 루프
        while(!s.equals("1")){
            int lenBefore = s.length();
            s=s.replace("0","");
            int lenAfter = s.length();
            
            //제거된 0의 갯수 갱신
            removeCnt += (lenBefore - lenAfter);
            
            int cnt=0;
            
            
            //이진 변환 코드는 Java에서 API를 제공함
            // s=Integer.toBinaryString(after);
            
            String temp = "";
            while(lenAfter>1){
                
                temp = (lenAfter%2) + temp;
                lenAfter/=2;
                
                cnt++;
            }
            
            s= "1"+temp;
            
            loopCnt++;
        }
        
        answer[0] = loopCnt;
        answer[1] = removeCnt;
        return answer;
    }
}