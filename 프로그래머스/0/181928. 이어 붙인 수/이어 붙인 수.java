class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        String odd_str = "";
        String even_str = "";
        
        for(int i=0; i<num_list.length; i++){
            int num = num_list[i];
            if(num % 2 != 0){
                odd_str += num;
            }else{
                even_str += num;
        
            }
        }
        return Integer.parseInt(odd_str) + Integer.parseInt(even_str);
        
        // return answer;
    }
}