class Solution {
    public String solution(String phone_number) {
        //char array로 변경하고 인덱스 접근
        char[] ca = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++){
            ca[i] = '*';
        }
        
        //다시 string으로 변경
        String answer = new String(ca);
        return answer;
    }
}