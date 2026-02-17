import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int count = 0;
        
        for(int food : scoville){
            pq.offer(food);
        }
        
        while(pq.size() >= 2 && pq.peek() < K){
            int firstNotSpicy = pq.poll();
            int secondNotSpicy = pq.poll();
            
            pq.offer(firstNotSpicy + secondNotSpicy * 2);
            count++;
        }
        
        return (pq.peek() < K) ? -1 : count;
    }
}