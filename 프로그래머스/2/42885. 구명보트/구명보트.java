import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int rideTogether = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left < right){
            if(people[left] + people[right] <= limit){ // 둘이 타기에 충분한 경우
                left++;
                right--;
                rideTogether++;
            }else{ // 한명밖에 못타는 경우 -> 무게가 더 많이 나가는 사람을 대체
                right--; 
            }
        }
        
        return people.length - rideTogether;
    }
}