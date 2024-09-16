class Solution {
    public boolean solution(int x) {
        String num_str = "" + x;
        int result = 0;
        for(int i=0; i<num_str.length(); i++){
            int num = Character.getNumericValue(num_str.charAt(i));
            result += num;
        }
        
        System.out.println(result);
        if(x % result == 0){
            return true;
        }
        return false;
    }
}