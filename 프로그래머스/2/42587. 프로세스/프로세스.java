import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> processes = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        
        for(int i=0; i<priorities.length; i++){
            processes.offer(new Node(priorities[i], i));
            pq.offer(priorities[i]); //우선순위 값 역순 정렬 후 저장
        }
        
        int count = 0;
        
        while(!processes.isEmpty()){
            
            Node current = processes.poll();
            
            if(current.priority == pq.peek()){ //현재 노드의 우선순위가 가장 높은 경우(pq의 제일 앞쪽의 값과 같음)
                pq.poll();
                count++;
                
                if(current.index == location){ //현재 노드의 위치가 찾으려는 위치인 경우
                    return count;
                }
            }else{
                processes.offer(current); //현재 노드보다 우선순위가 높은게 있는 경우, 다시 큐 뒤에 삽입
            }
            
            // boolean hasHigher = false;
            
//             for(Node node : processes){ //우선순위가 높은 노드 찾기
//                 if(node.priority > current.priority){
//                     hasHigher = true;
//                     break;
//                 }
//             }
            
//             if(hasHigher){ //우선순위가 높은 노드를 찾았을 때, 현재 노드를 뽑지 않고 뒤에 넣음
//                 processes.offer(current);
//             }else{ //자기 자신이 우선순위가 가장 높다면, 현재 뽑은 노드(자기 자신)를 제거하고 count++
//                 count++;
                
//                 if(current.index == location){ //현재 노드가 찾던 위치의 노드일때
//                     return count;
//                 }
//             }
        }
        
        return count;
    }
    
    static class Node{
        int priority;
        int index;
        
        Node(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
}