class Solution {
    public String solution(String[] seoul) {
        // String answer = "";
        // return answer;
        
        for(int i=0; i<seoul.length; i++){
            System.out.println(seoul[i]);
            if(seoul[i].equals("Kim")){
                System.out.println("test");
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }
}