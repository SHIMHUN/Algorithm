class Solution {
    public long solution(int a, int b) {
//         if(a == b){
//             return a;
//         }
        
//         int start, end;
//         int result = 0;
        
//         if(a>b){
//             start = b;
//             end = a;
//         }
//         else{
//             start = a;
//             end = b;
//         }
        
//         for(int i=start; i<=end; i++){
//             result += i;
//         }
        
//         return result;
        
        long result = 0;
        long start = (a < b)? a : b;
        long end = (a > b)? a : b;
        
        if(start == end){
            return start;
        }
        
        while(start < end){
            result += start;
            start++;
        }
        return result+end;
    }
}