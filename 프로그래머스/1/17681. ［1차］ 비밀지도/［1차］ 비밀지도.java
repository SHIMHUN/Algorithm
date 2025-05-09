class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]); // OR 연산 후 2진수(문자열) 변환
            
            System.out.println(binary);
            if(binary.length() < n){
                binary = "0".repeat(n-binary.length()) + binary;
                // binary = "0" + binary;
            }
            
            binary = binary.replace('1', '#');
            binary = binary.replace('0', ' ');

            answer[i] = binary; 
        }
        
        return answer;
    }
}