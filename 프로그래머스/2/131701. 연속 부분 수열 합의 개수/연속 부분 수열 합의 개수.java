import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        
//         for(int i=1; i<elements.length; i++){ // 0, 1, 2, 3 ... 연속 수열 최대 갯수
//             for(int j=0; j<elements.length; j++){
//                 int sum = 0;
                
//                 for(int z=j; z<i; z++){ 
//                     sum += elements[(z+i)%elements.length];
//                 }
//                 System.out.println(i + " " + sum);
//                 set.add(sum);
//             }

//         }
        for(int z=1; z<=elements.length; z++){
            for(int i=0; i<elements.length; i++){
                int sum = 0;
                for(int j=0; j<z; j++){ //오프셋
                    sum += elements[(i+j)%elements.length];
                    // System.out.println(z + " " + sum);

                }
                // System.out.println(z + " " + sum);
                set.add(sum);
            }
        }

        // set.add()
        int answer = set.size();
        return answer;
    }
}