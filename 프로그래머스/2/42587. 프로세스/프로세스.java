import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> processes = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            processes.offer(new Node(priorities[i], i));
        }
        
        int count = 0;
        
        while(!processes.isEmpty()){
            
            Node current = processes.poll();
            
            boolean hasHigher = false;
            
            for(Node node : processes){ //우선순위가 높은 노드 찾기
                if(node.priority > current.priority){
                    hasHigher = true;
                    break;
                }
            }
            
            if(hasHigher){ //우선순위가 높은 노드를 찾았을 때, 현재 노드를 뽑지 않고 뒤에 넣음
                processes.offer(current);
            }else{ //자기 자신이 우선순위가 가장 높다면, 현재 뽑은 노드(자기 자신)를 제거하고 count++
                count++;
                
                if(current.index == location){ //현재 노드가 찾던 위치의 노드일때
                    return count;
                }
            }
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