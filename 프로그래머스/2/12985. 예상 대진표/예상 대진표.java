class Solution
{
    public int solution(int n, int a, int b)
    {   
        int round = 1;
        while((a+1)/2 != (b+1)/2){
            a = (a/2 + a%2);
            b = (b/2 + b%2);
            round++;
        }
        
        return round;
    }
}