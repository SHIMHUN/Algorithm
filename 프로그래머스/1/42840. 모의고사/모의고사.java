import java.util.*;

class Solution {
    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,2,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    
    static List<Integer> al = new ArrayList<>();
    
    public Integer[] solution(int[] answers) {
        
        int first_cnt = calc(first, answers);
        int second_cnt = calc(second, answers);
        int third_cnt = calc(third, answers);
    
        int max = Math.max(first_cnt,second_cnt);
        max = Math.max(max, third_cnt);
        
        if(first_cnt == max){
            al.add(1);
        }
        if(second_cnt == max){
            al.add(2);
        }
        if(third_cnt == max){
            al.add(3);
        }
        
        Integer[] answer = new Integer[al.size()];

        return al.toArray(answer);
    }
    
    int calc(int[] a, int[] b){
        int cnt = 0;
        
        for(int i=0; i<b.length; i++){
            System.out.println(b[i] + " " + a[i%a.length]);
            
            if(b[i] == a[i%a.length]){
                cnt++;
            }
        }
        return cnt;

    }
}