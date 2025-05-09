class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1_idx=0; //뭉치1 포인터
        int card2_idx=0; //뭉치2 포인터
        
        for(String word : goal){
            if(card1_idx != cards1.length && cards1[card1_idx].equals(word)){
                card1_idx++;
            }else if(card2_idx != cards2.length && cards2[card2_idx].equals(word)){
                card2_idx++;   
            }else{
                return "No";   
            }
        }
        
        return "Yes";
    }
}