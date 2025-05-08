class Solution {
  public String[] solution(String[] strings, int n) {

      for(int i=0; i<strings.length-1; i++){
          for(int k=i+1; k<strings.length;k++){
              if(strings[i].charAt(n)>strings[k].charAt(n)){ 
                  String tmp = strings[i];
                  strings[i]= strings[k];
                  strings[k]=tmp;
              }
              else if(strings[i].charAt(n)==strings[k].charAt(n)){
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