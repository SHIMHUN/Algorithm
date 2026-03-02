import java.util.*;

class Solution {
    String firstStr;
    String secondStr;
    
    HashMap<String, Integer> map1 = new HashMap<>();
    HashMap<String, Integer> map2 = new HashMap<>();
    
    public int solution(String str1, String str2) {
        
        this.firstStr = str1.toLowerCase();
        this.secondStr = str2.toLowerCase();
        
        for(int i=0; i<firstStr.length()-1; i++){

            char c1 = firstStr.charAt(i);
            char c2 = firstStr.charAt(i+1);
            
            //영문자인지 확인
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String sliceWord = "" + c1 + c2;
                System.out.println("firstStr: " + sliceWord);
                map1.put(sliceWord,map1.getOrDefault(sliceWord,0)+1);  
            }

        }
        
        for(int i=0; i<secondStr.length()-1; i++){
            char c1 = secondStr.charAt(i);
            char c2 = secondStr.charAt(i+1);
            
            //영문자인지 확인
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String sliceWord = "" + c1 + c2;
                System.out.println("secondStr: " + sliceWord);
                map2.put(sliceWord,map2.getOrDefault(sliceWord,0)+1);  
            }
        }
        
        HashSet<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        int plus = 0;
        int mul = 0;
        
        for(String key : keys){ //교집합, 합집합 계산
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);

            mul += Math.min(count1, count2);
            plus += Math.max(count1, count2);
        }
        
        if(mul == 0 && plus == 0) return 65536;
        else return 65536 * mul / plus;
    }
}