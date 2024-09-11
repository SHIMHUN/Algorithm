class Solution {
    public int[] solution(long n) {
        //1.StringBuilder 객체로 변환하기
        //2.자리수 각각 구하기
        
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        // System.out.println(s);
        for(int i=0; i<s.length(); i++){
            // System.out.println(Character.getNumericValue(s.charAt(i)));
            answer[s.length()-i-1] = Character.getNumericValue(s.charAt(i));
            // answer[i] = Character.getNumericValue(s.charAt(i));
        }
        
        return answer;
    }
}