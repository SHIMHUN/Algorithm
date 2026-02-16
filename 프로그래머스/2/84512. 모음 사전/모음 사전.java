class Solution {
    String target;
    int count=0;
    boolean found = false;
    char[] vowels = {'A','E','I','O','U'};
    
    public int solution(String target) {
        this.target=target;
        dfs("");
        return count;
    }
    
    void dfs(String word){
        // count++;
        
        if(found == true){
            return;
        }
        
        // if(word.equals(target)){ //단어 찾았을 때
        //     found = true;
        //     return;
        // }
        
        // 빈 문자열이 아닐 때만 카운트
        if(!word.equals("")){
            count++;
            if(word.equals(target)){
                found = true;
                return;
            }
        }
        
        
        if(word.length() == 5){ //길이 5 넘어갈때
            return;
        }
        
        
        dfs(word+"A");
        dfs(word+"E");
        dfs(word+"I");
        dfs(word+"O");
        dfs(word+"U");
        
        return;
    }
}