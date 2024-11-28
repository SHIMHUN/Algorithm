class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<right+1; i++){
            int num = getDiv(i);
            System.out.println(num);
            if(num%2 == 0){
                answer+=i;
            }else{
                answer-=i;
            }
        }
        
        return answer;
    }
    
    //약수 구하는 함수, 리턴 값은 약수의 갯수
    public static int getDiv(int n){
        int sum = 0;
        for(int i=1; i<n/2+1; i++){
            if(n%i == 0){ //i가 약수인 경우
                // System.out.println(i);

                sum+=1;
            }
        }
        return sum+1; 
        
    }
}