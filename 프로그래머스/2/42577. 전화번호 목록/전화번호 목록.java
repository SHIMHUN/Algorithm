import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        
        boolean answer = true;
        Arrays.sort(phone_book); //문자열형태의 숫자 정렬은 길이순이 아니라 앞에서부터 문자를 비교하면서 숫자가 작은거부터 앞에 옴
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }

        }
        
        return true;
    }
}