import java.util.*;

class Solution {
    static Map<String, String> map = new HashMap();
    
    public int solution(String s) {
        
        String tmp = "";
        String result = "";
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        for(int i=0; i<s.length()-1; i++){
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            
            
            // 현재 인덱스, 다음 인덱스 둘다 문자
            if(curr>='a' && curr<='z' && next>='a' && next<='z'){ 
                tmp+=curr;
                if(map.containsKey(tmp)){ //문자형태의 숫자들이 연속적으로 나열되어있는 경우 고려
                    result+=map.get(tmp);
                    tmp="";
                }
            }
            
            // 현재 인덱스 문자, 다음 인덱스 숫자
            else if(curr>='a' && curr<='z' && next>='0' && next<='9'){
                tmp+=curr;
                result+=map.get(tmp); //map에서 해당하는 숫자 찾기
                tmp=""; //임시 문자열 초기화
            }
            
            //현재 인덱스 숫자 -> 결과에 추가
            else{
                result+=curr;
            }
        }
        
        char c = s.charAt(s.length()-1);
        if(c >= 'a' && c <= 'z'){
            tmp+=c;
            result+=map.get(tmp);
        }
        else{
            result+=c;
        }
        
        System.out.println(result);
        int answer = Integer.parseInt(result);
        return answer;
    }
}