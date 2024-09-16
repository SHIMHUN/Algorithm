class Solution {
    public long solution(long n) {
        long answer = 0;
        // 1. Math.pow()
        // 2. Math.sqrt()
        double result = Math.sqrt(n);
        if(result%1 == 0){
            return (long)Math.pow(result+1,2);
        }
        return -1;
    }
}