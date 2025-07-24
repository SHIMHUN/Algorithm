/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        if(n == 1) return 1;

        while(left <= right){
            int mid = left + (right-left)/2;
            int guess = guess(mid);

            if(guess == -1){ // down해야함
                right = mid - 1;
            }else if(guess == 1){  // up해야함
                left = mid + 1;
            }else{
                return mid;
            }
        }
        
        return right;
    }
}