import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int n) {
        int[] answer = {};
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            if(i%2!=0){
                al.add(i);
            }
        }
        
        return al;
    }
}