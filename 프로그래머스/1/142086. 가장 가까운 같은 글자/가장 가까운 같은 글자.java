class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        result[0] = -1;
        
        for(int i=1; i<s.length(); i++){ //배열 원소들을 -1로 초기화
            result[i] = -1;
        }
        
        for(int i=1; i<s.length(); i++){
            // int same = 0; //몇칸 앞에 있는지 확인
            for(int j=i-1; j>=0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    // same = i-j;
                    result[i] = i-j;
                    break;
                }
            }
        }
        
        return result;
    }
}