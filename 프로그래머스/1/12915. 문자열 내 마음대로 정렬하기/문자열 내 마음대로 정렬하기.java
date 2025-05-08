import java.util.*;

class Solution {
  static Map<Character, PriorityQueue<String>> map = new TreeMap<>();
  static ArrayList<String> al = new ArrayList<>();
    
  public String[] solution(String[] strings, int n) {
      
//         //1. 주어진 자료구조 최대한 활용(조금 더 느림, 메모리 사용량은 비슷)
//         String[] answer = new String[strings.length];
        
//         for(int i=0; i<strings.length; i++){
//             //key에 해당하는 값이 없으면 우선순위 큐 새로 생성해서 삽입
//             map.putIfAbsent(strings[i].charAt(n), new PriorityQueue<>());

//             //key에 해당하는 value로 큐를 가져와서 문자열 삽입
//             map.get(strings[i].charAt(n)).offer(strings[i]);
//         }

//         //value값만 탐색
//         for(PriorityQueue<String> pq : map.values()){

//             //큐의 첫번째 값을 제거하고 반환하여 결과 배열에 추가
//             while(!pq.isEmpty()){
//                 al.add(pq.poll());
//             }
//         }

//         //ArrayList를 String[] 배열로 변환
//         al.toArray(answer);

//         return answer;
      
        //2. 버블정렬 형태로 구현(더 빠름)
        for(int i=0; i<strings.length-1; i++){
            for(int k=i+1; k<strings.length;k++){
                //해당하는 인덱스의 원소가 더 큰 경우 위치 교체
                if(strings[i].charAt(n)>strings[k].charAt(n)){ 
                    String tmp = strings[i];
                    strings[i]= strings[k];
                    strings[k]=tmp;
                }
                //해당하는 인덱스의 원소가 같은 경우
                else if(strings[i].charAt(n)==strings[k].charAt(n)){
                    //사전 순으로 첫번째 문자열이 뒤에있는 경우 위치 교체
                    if(strings[i].compareTo(strings[k]) >0){ 
                        String tmp = strings[i];
                        strings[i]= strings[k];
                        strings[k]=tmp;
                    }
                }
            }
        }
        return strings;
  }
}