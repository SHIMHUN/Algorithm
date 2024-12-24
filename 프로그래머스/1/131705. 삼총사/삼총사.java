import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        // Arrays.sort(number);
        
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int z=j+1; z<number.length; z++){
                    
                    if(number[i]+number[j]+number[z] == 0){
                        System.out.println("" + i + j + z);
                        // System.out.println(number[i]);
                        // System.out.println(number[j]);
                        // System.out.println(number[z]);
                        if(i==1){
                            System.out.println("test");
                        }
                        
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}