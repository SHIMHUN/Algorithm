class Solution {
    public boolean solution(int x) {
        String num_str = "" + x;
        int result = 0;
        // for(int i=0; i<num_str.length(); i++){
        //     int num = Character.getNumericValue(num_str.charAt(i));
        //     result += num;
        // }
        int new_x = x;
        while(new_x>0){
            // System.out.println(x/10);
            // System.out.println(x%10);

            // System.out.println(x);

            result += (new_x%10);
            // System.out.println(result);

            new_x/=10;
        }
        // result+=x;
        System.out.println(result);
        return x % result == 0;
    }
}