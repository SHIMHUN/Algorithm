class Solution {
    public int solution(String name) {
        int cnt = 0;
        int len = name.length();
        int move = len-1; // 좌우 움직임 수
        
        for(int i=0; i<len; i++){
            char c = name.charAt(i);
            
            cnt+=Math.min('Z'-c+1, c-'A');
            
            int next = i+1;
            while(next<len && name.charAt(next) == 'A'){
                next++;
            }
            
            move = Math.min(move, i*2 + len - next); //앞부터 시작했다가 돌아가기
            move = Math.min(move, (len-next)*2 + i); //뒤부터 시작했다가 돌아가기
            
        }
        return cnt+move;
    }
}