class Solution {
    static int cnt = 0;
    
    public int solution(int a, int b, int n) {
        recur(a,b,n);
        return cnt;
    }
    
    void recur(int a, int b, int n){
        if(n < a){ //남은 병 갯수가 a보다 작으면 종료
            return;
        }
        
        int x = n/a*b; //반환되는 병 갯수
        int y = n % a; //나머지
        cnt+=x;
        
        System.out.println(x + " " + y);
        recur(a, b, x+y);
    }
}