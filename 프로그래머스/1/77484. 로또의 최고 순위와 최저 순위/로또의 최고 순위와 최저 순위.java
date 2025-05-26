import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int cnt=0;
        int score=0;
        
        for(int num : lottos){
            if(num == 0){ //0인 경우
                cnt++;
            }else{
                for(int win_num : win_nums){ 
                    if(num == win_num){ //번호 맞춘 경우
                        score++;
                        break;
                    }
                }
            }
        }


        int max_score = score + cnt;
        int min_score = score;
        
        answer[0] = getRank(max_score);
        answer[1] = getRank(min_score);
        return answer;
    }
    
    public int getRank(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
        
    }
}