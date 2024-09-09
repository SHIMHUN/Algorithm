class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String str = s.toLowerCase();
        int p_cnt = 0;
        int y_cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(str.charAt(i) == 'p'){
                p_cnt++;
            }
            else if(str.charAt(i) == 'y'){
                y_cnt++;
            }
        }
//         if(p_cnt == y_cnt){
//             return true;
//         }
//         else{
//             return false;
//         }
        
//         return true;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
    
        // return answer;
        return p_cnt == y_cnt;
    }
}