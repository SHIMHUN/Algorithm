class Solution {
    static int cnt=0;
    
    public int solution(int n, int m, int[] section) {
        int result = 1; //처음 한번은 무조건 페인트칠
        int start = section[0];
        int end = start+m-1;
        
        for(int num : section){
            if(num >= start && num <= end){ //범위 안에 있으면 추가적인 페인트칠 x
                continue;
            }else{ 
                start = num;
                end = num + m-1;
                result++; //범위를 벗어났으면 새로운 페인트칠
            }
        }
        
        return result;
    }
}