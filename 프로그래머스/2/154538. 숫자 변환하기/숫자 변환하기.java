import java.util.*;

class Solution {
    int y, n;
    static int minimumCnt=-1;
    
    public int solution(int x, int y, int n) {
        Deque<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        
        queue.add(new Node(x, 0));
        visited[x] = true;
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            
            if(curr.sum == y){
                return curr.cnt;
            }
            
            int[] nextValues = {curr.sum+n, curr.sum*2, curr.sum*3};
            
            for(int next : nextValues){
                if(next <= y && !visited[next]){
                    visited[next] = true;
                    queue.add(new Node(next, curr.cnt+1));
                }
            }
        }
        
        return -1;
    }
    
    void bfs(int sum, int cnt){
        if(sum == y) {            
            if(minimumCnt == -1) minimumCnt = cnt;
            else minimumCnt = Math.min(cnt, minimumCnt);
            return;
        }
        else if(sum > y) return;
        
        bfs(sum+n, cnt+1);
        bfs(sum*2, cnt+1);
        bfs(sum*3, cnt+1);
    }
    
    static class Node{
        int sum;
        int cnt;
        
        Node(int sum, int cnt){
            this.sum = sum;
            this.cnt = cnt;
        }
    }
}