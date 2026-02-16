import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dx = {1,-1,0,0}; // 동,서,남,북
        int[] dy = {0,0,1,-1};
        
        queue.offer(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            int cnt = curr.cnt;
            
            if(x == maps.length-1 && y == maps[0].length-1){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && !visited[nx][ny] && maps[nx][ny]==1){

                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, cnt+1));
                
                }
            }
        }
        
        return -1;
    }
    
    static class Node{
        
        int x;
        int y;
        int cnt;
        
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}