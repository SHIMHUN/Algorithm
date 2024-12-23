class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0, 0};
        
        int max = (n>m)? n:m;
        int min = (n>m)? m:n;
        
        //최대 공약수
        int a = 0;
        for(int i=min; i>0; i--){
            if(min % i == 0 && max % i == 0){
                a = i;
                break;
            }
        }
        System.out.println(a);

        
        //최소 공배수
        // for(int i=0; i<min;)
        int i=1;
        int b=0;
        while(true){
            if(max*i % min == 0){
                b=max*i;
                break;
            }
            i++;
        }
        System.out.println(b);
        answer[0]=a;
        answer[1]=b;
        return answer;
    }
}