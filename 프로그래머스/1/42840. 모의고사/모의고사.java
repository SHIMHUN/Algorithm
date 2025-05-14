import java.util.*;

class Solution {
    
    //각 수포자가 기재한 답 배열 선언
    static int[] first = {1,2,3,4,5};
    static int[] second = {2,1,2,3,2,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    
    static List<Integer> al = new ArrayList<>();
    
    public List<Integer> solution(int[] answers) {
        
        int first_cnt = calc(first, answers);
        int second_cnt = calc(second, answers);
        int third_cnt = calc(third, answers);
        
        // 가장 많이 맞은 갯수 구하기
        int max = Math.max(Math.max(first_cnt,second_cnt), third_cnt);
        
        // 가장 많은 문제를 맞힌 사람 구하기(동점자 고려)
        if(first_cnt == max){
            al.add(1);
        }
        if(second_cnt == max){
            al.add(2);
        }
        if(third_cnt == max){
            al.add(3);
        }
        
        return al;
        // Integer[] answer = new Integer[al.size()];
        // return al.toArray(answer);
    }
    
    int calc(int[] a, int[] b){
        int cnt = 0;
        
        //정답과 기재한 답 비교후 맞은 갯수 구하기
        for(int i=0; i<b.length; i++){
            if(b[i] == a[i%a.length]){
                cnt++;
            }
        }
        return cnt;

    }
}