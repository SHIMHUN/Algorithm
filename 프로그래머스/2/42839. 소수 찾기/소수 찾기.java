import java.util.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;
    
    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        dfs("");
        int cnt = 0;
        for(int num : set){
            if(isPrime(num)) cnt++;
        }
        
        return cnt;
    }
    
    public void dfs(String s){
        if(!s.equals("")){
            set.add(Integer.parseInt(s));
        }
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(s + numbers.charAt(i));
                visited[i]=false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n < 2) return false;
        
        for(int i=2; i<=n/2; i++){
            if(n%i == 0) return false;
        }          
        
        return true;
    }
}