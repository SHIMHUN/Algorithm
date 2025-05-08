import java.util.*;

class Solution {
    static Map<Character, PriorityQueue<String>> map = new TreeMap<>();
    static ArrayList<String> al = new ArrayList<>();
    
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for(int i=0; i<strings.length; i++){
            //key에 해당하는 값이 없으면 우선순위 큐 새로 생성해서 삽입
            map.putIfAbsent(strings[i].charAt(n), new PriorityQueue<>());
            
            //key에 해당하는 value로 큐를 가져와서 문자열 삽입
            map.get(strings[i].charAt(n)).offer(strings[i]);
        }
        
        //value값만 탐색
        for(PriorityQueue<String> pq : map.values()){
            
            //큐의 첫번째 값을 제거하고 반환하여 결과 배열에 추가
            while(!pq.isEmpty()){
                al.add(pq.poll());
            }
        }
        
        //ArrayList를 String[] 배열로 변환
        al.toArray(answer);
        
        return answer;
    }
}