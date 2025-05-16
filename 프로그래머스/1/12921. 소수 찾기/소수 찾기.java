class Solution {
  public int solution(int n) {
      int answer = 0;
            
      for(int i = 2; i <= n; i++){
          boolean chk = true;
          for(int j = 2; j*j <= i; j++){ //배수 지우기
              if(i % j == 0){
                  chk = false;
                  break;
              }
          }
          if(chk){
              answer++;
          }
      }
      
     return answer;           
      
  }
}
