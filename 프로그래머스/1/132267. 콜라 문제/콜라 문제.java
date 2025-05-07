class Solution {
    static int cnt = 0;
    
    public int solution(int a, int b, int n) {
        // //1. 재귀함수 이용
        // recur(a,b,n);
        
        //2. 일반 반복문 이용
        while (n >= a) { // 남은 병이 a보다 크거나 같을 동안 계속 교환을 반복
            int x = n / a * b; 
            int y = n % a;
            cnt += x; 
            n = x + y; 
        }
        
        return cnt;
    }
    
    void recur(int a, int b, int n){
        if(n < a){ //남은 병 갯수가 a보다 작으면 종료
            return;
        }
        
        int x = n/a*b; //반환되는 병 갯수
        int y = n % a; //나머지
        cnt+=x;
        
        recur(a, b, x+y);
    }
}