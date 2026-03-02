import java.util.*;

class Solution {
    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    int time=0;
    int currWeight=0;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // Arrays.sort(truck_weights);
        for(int truck : truck_weights){
            stack.push(truck);
        }
        for(int i=0; i<bridge_length; i++){
            queue.offer(0);
        }
        
        while(!stack.isEmpty()){
            //다리 맨 앞 트럭 or 빈공간(0) 제거
            currWeight-=queue.poll();
            
            //새트럭 올릴 수 있는지 체크
            if(stack.peek() + currWeight <= weight){
                int truck = stack.pop();
                queue.offer(truck);
                currWeight+=truck;
            }else{
                queue.offer(0);
            }
            time++;
        }
        
        return time+=bridge_length;
    }
}