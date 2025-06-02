class Solution {
    static int[] memo;

    public int solution(int n) {
        memo = new int[n+1];
        return fib(n);
    }

    private int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n]; // 이미 계산된 값이면 바로 반환

        // 계산 후 저장(메모이제이션)
        memo[n] = (fib(n-1) + fib(n-2)) % 1234567;
        return memo[n];
    }
}
